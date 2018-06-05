package com.revature.banking.menus;

import java.util.ArrayList;

import com.revature.banking.pojos.BankAccount;

public class ManageMenu extends Menu{

private static ManageMenu manageMenu=null;
	
	ManageMenu() {
		options=new ArrayList<String>();
		message="Manage Account Menu";
		options.add("1. Make Deposit");
		options.add("2. Make Withdraw");
		options.add("3. Check Balance");
		options.add("4. Exit to Account Menu");
	}
	public static Menu getInstance() {
		if(manageMenu==null)
			manageMenu=new ManageMenu();
		return manageMenu;
	}

	@Override
	public void switcher() {
		clear();
		int which=select();
		switch(which) {
		case 1:
			clear();
			deposit_withdraw(account.getBankAccounts(), 'd');
			break;
		case 2:
			clear();
			deposit_withdraw(account.getBankAccounts(), 'w');
			break;
		case 3:
			clear();
			
			if(account.getBankAccounts().isEmpty()) {
				System.out.println("You have not created a bank account yet");
				System.out.println();
				System.out.println("Press Enter to Return to Account Menu");
				scanner.nextLine();
				clear();
				new AccountMenu().getInstance().switcher();
			}
			else {
				int index;
				if(account.getBankAccounts().size()>1)
					index=goThroughBankAccounts(account.getBankAccounts());
				else
					index=1;
				System.out.println("Balance of "+account.getBankAccounts().get(index-1).getAcc_type()+
						" ACCOUNT "+account.getBankAccounts().get(index-1).getAcc_num()+
						" is $"+account.getBankAccounts().get(index-1).getBalance());
				System.out.println();
				System.out.println("Press Enter to Return to Manage Account Menu");
				scanner.nextLine();
				new ManageMenu().getInstance().switcher();
				
			}
			break;
		case 4:
			clear();
			new AccountMenu().getInstance().switcher();
		default:
			new ManageMenu().getInstance().switcher();
	}
	}
	
	private int goThroughBankAccounts(ArrayList<BankAccount> bankAccounts) {
		int whichAccount=0;
		int count=1;
		
		while(whichAccount==0) {
			System.out.println("Which Account");
			for(BankAccount ba: bankAccounts) {
				System.out.println(count+". "+ba.getAcc_type()+" "+ba.getAcc_num());
				count++;
			}
			
			try {
				whichAccount=Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				clear();
				System.out.println("Invalid Entry");
				whichAccount=0;
				count=1;
			}
			
			if(whichAccount>=count || whichAccount<=0) {
				whichAccount=0;
				count=1;
			}
		}
		
		return whichAccount;
	}
	
	private void deposit_withdraw(ArrayList<BankAccount> bankAccounts, char which) {
		int whichAccount=0;
		BankAccount current;
		
		bankAccounts=account.getBankAccounts();
		if(bankAccounts.isEmpty()) {
			System.out.println("You have not created a bank account yet");
			System.out.println();
			System.out.println("Press Enter to Return to Account Menu");
			scanner.nextLine();
			clear();
			new AccountMenu().getInstance().switcher();
		}
		else {
			int count=1;
			double amount=-1;
			String check;
			
			if(bankAccounts.size()>1) {
				whichAccount=goThroughBankAccounts(bankAccounts);
				current=bankAccounts.get(whichAccount-1);
			}
			else
				current=bankAccounts.get(0);
			
			
			
			while(amount<0) {
				if(which=='d')
					System.out.println("How much would you like to deposit?");
				else
					System.out.println("How much would you like to withdraw?");
				try {
					check=scanner.nextLine();
					amount=Double.parseDouble(check);
					if(check.contains(".") && check.substring(check.indexOf(".")).length()>3) {
						clear();
						System.out.println("Can only take a number with up to 2 decimal places");
						String choice=exitOut("Manage Account Menu");
						
						if(choice.equals("1")) {
							amount=0;
						}
						else {
							amount=-1;
							continue;
						}
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					clear();
					System.out.println("Invalid Entry");
					amount=-1;
				}
				if(amount>0) {
					boolean allGood;
					if(which=='d') {
						allGood=current.depsoit(amount);
						if(allGood)
							System.out.println("Deposit successful. Account balance is now $"+current.getBalance());
						else
							System.out.println("Error, something went wrong. Please try again");
					}
					else {
						allGood=current.withdraw(amount);
						if(allGood)
							System.out.println("Withdraw successful. Account balance is now $"+current.getBalance());
						else {
							System.out.println("Amount is higher than balance. Balance is $"+current.getBalance());
							String choice=exitOut("Manage Account Menu");
							
							if(choice.equals("1")) {
								new ManageMenu().getInstance().switcher();
								break;
							}
							else {
								amount=-1;
								continue;
							}
						}
					}
					
					System.out.println();
					System.out.println("Press Enter to Return to Manage Account Menu");
					account=access.logIn(account.getUser_name(), account.getPass());
					scanner.nextLine();
					clear();
					new ManageMenu().getInstance().switcher();
				}
				else if(amount<0) {
					invalid();
					String choice=exitOut("ManageMenu");
					
					if(choice.equals("1")) {
						clear();
						new ManageMenu().getInstance().switcher();
						break;
					}
				}
				else {
					clear();
					new ManageMenu().getInstance().switcher();
				}
			}
			
		}
	}
}


