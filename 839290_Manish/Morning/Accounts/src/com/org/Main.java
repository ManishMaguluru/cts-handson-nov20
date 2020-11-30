package com.org;

import java.util.Scanner;
import java.util.Set;

public class Main{

	public static void main(String[] args) throws AccountNotFoundException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		AccountService aService = new AccountService();
		
		
		
		int flag = 1;
		while(flag!=0) {
			System.out.println("Enter your choice:\n1.addAccount \n2.Remove account by account number \n3.display account by account number"
					+ "\n4.Display all accounts \n5.display accounts having balance is less than 1000 \n6.Exit");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 :  	try {
							System.out.println("Enter details to add an Account");
							System.out.println("Enter Account number: ");
							int accNo = sc.nextInt();
							System.out.println("Enter Account Name: ");
							String name = sc.next();
							System.out.println("Enter balance: ");
							double balance = sc.nextDouble();
							aService.addAccount(new Account(accNo,name,balance));
						} catch (AccountAlreadyExistsException e) {
							System.out.println("Account Already Exists");
						}
						break;
			
			case 2 :   		System.out.println("Remove account of account number: ");
							int accno = sc.nextInt();
							try {
							aService.RemoveAccount(accno);
							}
							catch(AccountNotFoundException ex) {
								System.out.println("There is no account with the account number: "+accno);
							}
							break;
			
			case 3 : 	 	System.out.println("Display account of an account number");
							int accnumber = sc.nextInt();
							try {
				   			Set<Account> accounts = aService.fetchAccountsList(accnumber);
				   			System.out.println("List of accounts are : "+accounts);
							}catch(AccountNotFoundException ex)
							{
								System.out.println("Account is not found with the account number: "+accnumber);
							}
				   			break;
			
			case 4 :   System.out.println("Display all accounts");
					   Set<Account> accountsList = aService.fetchAccountsList();
					   System.out.println("List of accounts are : "+accountsList);
					   break;
					   
			case 5 :   	System.out.println("Display accounts less than 1000");
						
			   			Set<Account> accountList = aService.fetchAccountsListbyBalance();
			   			System.out.println("List of accounts are : "+accountList);
			   			break;
			   			
			case 6 :	flag=0;
						break;
					   
			}
			
			
		}
		
		
		
	}

}
