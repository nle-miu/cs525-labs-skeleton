package edu.mum.cs.cs525.labs.skeleton.lab4_factory_pattern.dao;

import edu.mum.cs.cs525.labs.skeleton.lab4_factory_pattern.model.Account;

import java.util.Collection;

public interface AccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(String accountnumber);
	Collection<Account> getAccounts();
}
