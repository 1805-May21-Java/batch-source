package driver;

import org.hibernate.Session;

import app.BankInterface;
import util.HibernateUtil;

public class Driver {
	public static void main( String[] args )
    {
		Session s = HibernateUtil.getSession();
		s.close();
    	BankInterface bankInterface = new BankInterface();
		bankInterface.bankInterface();
    }
}
