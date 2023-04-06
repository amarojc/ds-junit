package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	/**
	 * @Test depósito e taxa de desconto:
	 * Deve aumentar o saldo da conta e a taxa de desconto quando o valor 
	 * de depósito for positivo.
	 */
	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		//Arrange
		double amount = 200.0;
		double expectedValue = 196.0;		
		Account acc = AccountFactory.createEmpytAccount();
		
		//Act
		acc.deposit(amount);
		
		//Assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	/**
	 * @Test depósito negativo:
	 * Não deve realizar nenhuma ação caso o valor for negativo
	 */
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	/**
	 * @Test retirada do valor total:
	 * Deve limpar o saldo e devolver o saldo total.
	 */
	@Test
	public void fullWhithdrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	/**
	 *@Test retirada saldo suficiente:
	 * Deve atualizar o saldo da conta após a retirada.
	 */
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		double initialBalance = 800.0;
		double withdraw = 500.0;
		double expectValue = 300.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		acc.withdraw(withdraw);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
		
	}
	
	/**
	 * @Test retirada saldo insufiente:
	 * Deve lançar uma exceção, na tentativa de retirada do valor.
	 */
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficentBalance() {
		double initialBalance = 800.0;
		double withdraw = 1000.0;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(initialBalance);
			acc.withdraw(withdraw);
		});
	}
}
