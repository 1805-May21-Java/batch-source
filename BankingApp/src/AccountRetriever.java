import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class AccountRetriever {

	private static AccountRetriever validator;
	private static String username;
	private static String password;
	private static String file = "src/accounts.txt";
	
	private AccountRetriever() {
		super();
	}
	
	public static AccountRetriever getInstance() {	
		return (validator == null)? validator = new AccountRetriever() : validator;		
	}
	
	public static BankAccount retrieve(String user, String pass) {

		
		String account = "";
		String[] accountDetails;
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			account = br.readLine();
			while (account != null) {
				accountDetails = account.split(" ");
				if(user.compareTo(accountDetails[0]) == 0) {
					if(pass.compareTo(accountDetails[1]) == 0) {
						return (new BankAccount(accountDetails[0], accountDetails[1], Double.parseDouble(accountDetails[2])));
					}
					account = br.readLine();
				} else {
					account = br.readLine();
				}
			}
			
		} catch (IOException f) {
			System.out.println("critical error file not found");
		} 
		
		return null;
	}
	
	public static void save(BankAccount account) {
		
		try(BufferedWriter bw  = new BufferedWriter(new FileWriter(file, true))) {
			bw.newLine();
			bw.write(account.getRecord());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void update(BankAccount account) {
		String currAccount = "";
		String[] accountDetails;
		ArrayList<String> accounts = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			currAccount = br.readLine();
			while(currAccount != null) {
				accountDetails = currAccount.split(" ");

				if(account.getUsername().compareTo(accountDetails[0]) == 0) {
					if(account.getPassword().compareTo(accountDetails[1]) == 0) {
						accounts.add(account.getRecord());
					}
				} else {
					accounts.add(currAccount);
				}
				currAccount = br.readLine();
			}
			
		} catch (IOException f) {
			System.out.println("critical error file not found");
		} 
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			Iterator<String> it = accounts.iterator();
			
			while(it.hasNext()) {
				bw.write(it.next());
				if(it.hasNext()) {
					bw.newLine();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean userNameInUse(String name) {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String account = br.readLine();
			String[] accountDetails = null;
			
			while (account != null) {
				accountDetails = account.split(" ");
				if(name.compareTo(accountDetails[0]) == 0) {
					return true;
				}
				account = br.readLine();
			}
			
		} catch (IOException f) {
			System.out.println("critical error file not found");
		} 
		
		return false;
	}
	
}
