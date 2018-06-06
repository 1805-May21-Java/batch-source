import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bank implements Serializable {

    private BankDaoImp db = new BankDaoImp();

    Customer openAccount(String firstName, String lastName, String ssn, AccountType type, Double balance) {
        int accountId = 0;
		try {
			accountId = db.AddAccount(firstName, lastName, ssn, type, balance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Customer customer = null;
		try {
			customer = db.GetAccount(accountId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return customer;
    }
    
    boolean closeAccount(int accountId) {
        try {
			return db.DeleteAccount(accountId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }

    Customer getCustomer(int accountId) throws IOException, SQLException {
			return db.GetAccount(accountId);
    }

    ArrayList<Customer> getCustomers() throws IOException, SQLException {
        return db.GetAllAccounts();
    }

    void withdraw(int accountId, double amount) throws InsufficientFundsException, IOException, SQLException {
        Customer customer = null;
		customer = getCustomer(accountId);
        double transactionFee = getTransactionFee(customer.getAccount().getAccountType());
        if (amount + transactionFee > customer.getAccount().getBalance()) {
            throw new InsufficientFundsException();
        }
        double newBalance = customer.getAccount().getBalance() - (amount + transactionFee);
        try {
			db.UpdateAccount(accountId, newBalance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    void deposit(int accountId, double amount) throws InvalidAmountException, IOException, SQLException {
        Customer customer = null;
		customer = getCustomer(accountId);
        if (amount <= 0) {
            throw new InvalidAmountException();
        }
        double interest = checkInterest(customer.getAccount().getBalance(), amount);
        double amountToDeposit = amount + (amount * interest);
        try {
			db.UpdateAccount(accountId, customer.getAccount().getBalance() + amountToDeposit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public double checkInterest(double balance, double amount) {
        double interest = 0;
        if (balance + amount > 10000) {
            interest = 0.05;
        } else {
            interest = 0.02;
        }
        return interest;
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    double getTransactionFee(AccountType accountType) {
        double transactionFee = 0;
        switch(accountType){
            case Checking:
                transactionFee = 5;
                break;
            case Savings:
                transactionFee = 5;
                break;
            case Undefined:
            default:
                transactionFee = 0;
        }
        return transactionFee;
    }

}