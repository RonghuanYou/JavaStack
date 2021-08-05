package com.ronghuan.bank_account;

public class BankAccountTest {

	public static void main(String[] args) {
		// INSTANTIATE AN ACCOUNT FOR USER (RONGHUAN)
		System.out.println("----------------Welcome Ronghuan--------------------");
		BankAccount Ronghuan = new BankAccount(0, 0);
		
		// INSUFFICIENT CASE
		Ronghuan.withdraw("Saving Account", 100);
		Ronghuan.withdraw("Checking Account", 2000);
		System.out.println("\n");


		// DEPOSIT AND WITHDRAW FROM SAVING ACCOUNT
		Ronghuan.deposit("Saving Account", 2000);
		Ronghuan.deposit("Checking Account", 100);
		System.out.println("\n");

		// CHECK GETTER/SETTER
		System.out.println("Balance in checking account: " + Ronghuan.getCheckingBalance());
		System.out.println("Balance in saving account: " + Ronghuan.getSavingBalance());
		
		// CHECK TOTAL AMOUNT FROM CHECKING AND SAVING
		Ronghuan.displayTotalBalance();
		
			
		// INSTANTIATE A ACCOUNT FOR USER (ISABEL)
		System.out.println("----------------Welcome Isabel--------------------");
		BankAccount Isabel = new BankAccount(0, 0);
			
		// DEPOSIT AND WITHDRAW FROM CHECKING ACCOUNT
		Isabel.deposit("Checking Account", 10000);
		Isabel.withdraw("Checking Account", 2000);
		Isabel.deposit("Saving Account", 5000);
		Isabel.withdraw("Saving Account", 2000);
		System.out.println("\n");

		// CHECK TOTAL AMOUNT FROM CHECKING AND SAVING
		Isabel.displayTotalBalance();

		// CHECK TEN DIGIT ACCOUNT NUMBER
		System.out.println("Your Checking Account number: " + Isabel.getAccountNumber());
		System.out.println("Your Saving Account number: " + Isabel.getAccountNumber());
		System.out.println("\n");

		// CHECK ACCOUNT NUMBER:
		Isabel.displayAccountCount();
	}
}
