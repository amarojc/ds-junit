package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	/**
	 * @Test construtor valores válidos:
	 * Deve criar o objeto com os dados corretos quando os valores forem válidos.
	 */
	@Test
	public void constructorShouldCreateObjectWhenValidData() {
		// Action
		Financing f = FinancingFactory.createFinancing(100000., 2000., 80);

		// Assert
		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
	}

	/**
	 * @Test construtor valores invalidos:
	 * Deve lançar um exceção quando os valores forem inválidos.
	 */
	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing f = FinancingFactory.createFinancing(100000., 2000., 20);
		});
	}

	/**
	 * @Test setar valor total do financiamento:
	 * Deve atualizar o valor quando os dados forem válidos
	 */
	@Test
	public void setTotalAmountShouldUpdateDataWhenValidData() {
		//Arrange
		Financing fin = FinancingFactory.createFinancing(100000., 2000., 80);
		
		//Action
		fin.setTotalAmount(80000.);
		
		//Assert
		Assertions.assertEquals(80000, fin.getTotalAmount());
	}

	/**
	 * @Test setar valor total do financiamento inválido:
	 * Deve lançar uma exceção quando os dados forem inválidos
	 */
	@Test
	public void setTotalAmountThrowIllegalArgumentExceptionWhenInvalidData() {
		//Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000., 2000., 80);
			fin.setTotalAmount(120000.);
		});
	}
	
	/**
	 * @Test setar a renda:
	 * Deve atualizar o valor quando os dados forem válidos
	 */
	@Test
	public void setIncomeShouldUpdateDataWhenValidData() {
		//Arrange
		Financing fin = FinancingFactory.createFinancing(100000., 2000., 80);
		
		//Action
		fin.setIncome(2200.);
		
		//Assert
		Assertions.assertEquals(2200.0, fin.getIncome());
	}
	
	/**
	 * @Test setar renda inválida:
	 * Deve lançar uma exceção quando os dados forem inválidos
	 */
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		//Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000., 80);
			fin.setIncome(1999.0);
		});
	}

	/**
	 * @Test setar meses:
	 * Deve atualizar o valor quando os dados forem válidos
	 */
	@Test
	public void setMonthsShouldUpdateDataWhenValidData() {
		//Arrange
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000., 80);
		
		//Action
		fin.setMonths(84);
		
		//Assert
		Assertions.assertEquals(84, fin.getMonths());
	}
	
	/**
	 * @Test setar meses inválidos:
	 * Deve lançar uma exceção quando os dados forem inválidos
	 */
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		//Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000., 80);
			fin.setMonths(79);
		});
	}
	
	/**
	 * @Test entrada
	 * Deve calcular corretamente o valor da entrada
	 */
	@Test
	public void entryShouldCalculateEntryCorrectly() {
		//Arranger
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000., 80);
		
		//Assert
		Assertions.assertEquals(20000.0, fin.entry());		
	}
	
	/**
	 * @Test prestação
	 * Deve calcular corretamente o valor da prestação
	 */
	@Test
	public void quotaShouldCalculateQuotaCorrectly() {
		//Arranger
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000., 80);
		
		//Assert
		Assertions.assertEquals(1000., fin.quota());
	}
}
