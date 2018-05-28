package menu;

import java.util.Scanner;

import com.revature.Client;

public class Menu {
	//Contains all menu and navigation for Tank Bank
	
	static Scanner scan = new Scanner(System.in);
	Client client;
	public static final String lineBreak = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	
	public Menu() {
		super();
		}
	
	public Menu(Client client) {
		super();
		this.client = client; 
	}
	
	//Exits program, static protected so other classes in the package can use it
	static protected void exit() {
		System.out.println("Have a good day!");
		System.exit(0);
	}
	
		//tank ascii to print on welcome screen
	public static String tank = 
			"  $         			    \n"+ 
			" $$$     					\n"+ 
			"$	   .--._____,		\n"+
			" $$$    .-='=='==-,		\n"+
			"    $	(O_o_o_o_o_O)		\n"+
			" $$$						\n"+
			"  $";
}