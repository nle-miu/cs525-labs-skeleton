package edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern;

import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.model.Account;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.model.AccountEntry;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.model.Customer;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.observer.email.EmailSender;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.observer.logger.Logger;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.observer.sms.SMSSender;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.subject.AccountService;
import edu.mum.cs.cs525.labs.skeleton.lab2_observer_pattern.subject.AccountServiceImpl;
import org.apache.logging.log4j.LogManager;

public class Application {
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		//initialize observers
		Logger logger = new Logger(accountService);
		SMSSender smsSender = new SMSSender(accountService);
		EmailSender emailSender = new EmailSender(accountService);

		// create 2 accounts;
		accountService.createAccount("1263862", "Frank Brown");
		accountService.createAccount("4253892", "John Doe");
		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);


		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		// show balances
		System.out.println();
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			
			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}



	}

}
