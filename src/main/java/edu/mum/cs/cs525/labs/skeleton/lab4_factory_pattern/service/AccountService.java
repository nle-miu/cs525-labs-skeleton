package edu.mum.cs.cs525.labs.skeleton.lab4_factory_pattern.service;

import edu.mum.cs.cs525.labs.skeleton.lab4_factory_pattern.model.Account;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}
