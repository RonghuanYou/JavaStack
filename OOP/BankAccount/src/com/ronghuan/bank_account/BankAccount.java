package com.ronghuan.bank_account;
import java.util.Random;

public class BankAccount {
	// ATTRIBUTES
	private double checkingBalance;
	private double savingBalance;
	private String accountNumber;

	// STATIC CLASS VARIABLE
	protected static int numOfAccounts;
	

	// CONSTRUCTOR
	public BankAccount(double checkingBalance, double savingBalance) {
		super();
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;

		// INCREASE THE ACCOUNT COUNT
		numOfAccounts += 1;
		// CALL PRIVATE METHOD TO GENERATE ACCOUNT NUMBER
		this.accountNumber = generateAccountNum();
	}

	// GETTER/SETTERS
	// Users are not allowed to set balance 
	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	// METHODS
	public void deposit(String accountType, int amount) {
		if (accountType.equals("Saving Account")) {
			savingBalance += amount;
			System.out.println("Deposit " + amount);
			System.out.println("Your saving account balance is " + savingBalance);
		}
		
		if (accountType.equals("Checking Account")) {
			checkingBalance += amount;
			System.out.println("Deposit " + amount);
			System.out.println("Your checking account balance is " + checkingBalance);
		}
	}
	

	public void withdraw(String accountType, int amount) {
		if (accountType.equals("Saving Account")) {
			if (savingBalance < amount) {
				System.out.println("Sorry, your saving account balance is insufficient.");
			} else {
				System.out.println("Withdraw " + amount);
				savingBalance -= amount;
				System.out.println("Your saving account balance is " + savingBalance);
			}
		}
		
		if (accountType.equals("Checking Account")) {
			if (checkingBalance < amount) {
				System.out.println("Sorry, your checking account balance is insufficient.");
			} else {
				System.out.println("Withdraw " + amount);
				checkingBalance -= amount;
				System.out.println("Your checking account balance is " + checkingBalance);
			}
		}
	}
	
	public void displayTotalBalance() {
		System.out.println("The total balance in checking account and saving account is $" + (checkingBalance + savingBalance));
	}
	
	// CLASS METHOD:
	public void displayAccountCount() {
		System.out.println("The number of accounts created is " + numOfAccounts);
	}
	
	// GENERATE TEN DIGITS ACCOUNT(ONLY RUN IT IN CURRENT CLASS)
	private String generateAccountNum() {
		String accountNumber = "";
		Random randomMachine = new Random();
		int max = 10;
		int i = 0;
		while (i < 10) {
			int digit = randomMachine.nextInt(max); // generate number from 0-9
			accountNumber += Integer.toString(digit); // concat every number
			i ++;
		}
		return accountNumber;
	}
}
