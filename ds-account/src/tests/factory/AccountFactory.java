package tests.factory;

import entities.Account;

public class AccountFactory {

	public static Account createEmpytAccount() {
		return new Account(1L, 0.0);
	}
	
	public static Account createAccount(double initialBalance) {
		return new Account(1l, initialBalance);
	}
}