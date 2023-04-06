package app;

import entities.Financing;
import tests.factory.FinancingFactory;

public class Program {

	public static void main(String[] args) {
		try {
			Financing fin1 = FinancingFactory.createFinancing(100000.0, 2000., 80);
			System.out.println("Financiamento autorizado!");
			System.out.println("Dados do financiamento 1:");
			System.out.printf("Entrada: %.2f%n", fin1.entry());
			System.out.printf("Prestação: %.2f%n", fin1.quota());
			
		} catch (Exception e) {
			System.out.println("Error no financiamento: " + e.getMessage());
		}

		try {
			Financing fin2 = FinancingFactory.createFinancing(100000.0, 2000., 20);
			System.out.println("Dados do financiamento 1:");
			System.out.printf("Entrada: %.2f%n", fin2.entry());
			System.out.printf("Prestação: %.2f%n", fin2.quota());
			
		} catch (Exception e) {
			System.out.println("Error no financiamento: " + e.getMessage());
		}
		
	}
}