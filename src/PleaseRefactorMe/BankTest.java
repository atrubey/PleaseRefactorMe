package PleaseRefactorMe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BankTest {
	public static void main(String[] args) {

		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		Bank b1 = new Bank();
		BankAccount bA1 = new BankAccount(new Date(2012 - 1900, Calendar.FEBRUARY, 12), 10000);
		BankAccount bA2 = new BankAccount(new Date(2015 - 1900, Calendar.JANUARY, 2), 5000);
		BankAccount bA3 = new BankAccount(new Date(2000 - 1900, Calendar.DECEMBER, 25), 15000);

		accounts.add(bA1);
		accounts.add(bA2);
		accounts.add(bA3);

		System.out.println("Account 1 Balance: " + bA1.getBalance());
		System.out.println("Account 2 Balance: " + bA2.getBalance());
		System.out.println("Account 3 Balance: " + bA3.getBalance());

		Bank.updateBalances(accounts);

		System.out.println("Account 1 Updated Balance: " + bA1.getBalance());
		System.out.println("Account 2 Updated Balance: " + bA2.getBalance());
		System.out.println("Account 3 Updated Balance: " + bA3.getBalance());

	}

}
