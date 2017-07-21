package PleaseRefactorMe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Bank {

	static void updateBalances(ArrayList<BankAccount> accounts) {
		for (BankAccount object : accounts) {
			// get interest
			double xtra = calculateInterest(object);
			// add interest to initial amount
			object.money = object.money + xtra;
		}

	}

	/**
	 * 
	 * @param account
	 *            (BankAccount object)
	 * @return interest amount (rate * time * initial amount) (double)
	 */
	static double calculateInterest(BankAccount account) {

		// get account date and balance
		Date dateOpened = account.date;
		double amount = account.getBalance();

		// set interest rate
		final double PERC = 2.54 / 100;

		// get current time
		Calendar a = Calendar.getInstance(Locale.US);
		a.setTime(new Date());
		// get time the account was created (initial time)
		Calendar b = Calendar.getInstance(Locale.US);
		b.setTime(dateOpened);

		// Get difference in years between when the account was created (b) and
		// current time (a)
		int diff = a.get(Calendar.YEAR) - b.get(Calendar.YEAR);

		// if current (a) month is greater than initial (b) month, add another
		// year OR if months are equal and current (a) day is greater than
		// initial (b) day, add another year
		if (a.get(Calendar.MONTH) < b.get(Calendar.MONTH)
				|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) < b.get(Calendar.DATE))) {
			diff++;
		}

		// return time * rate * initial amount = interest
		return diff * PERC * amount;
	}

}
