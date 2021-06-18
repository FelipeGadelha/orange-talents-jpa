package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class CreateAccountWithBalanceTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Account account = new Account();
		account.setHolder("Juliano");
		account.setNumber(12345);
		account.setAgency(54321);
		account.setBalance(500.0);
		
		manager.getTransaction().begin();
		manager.persist(account);
		manager.getTransaction().commit();
		
		
		
		
	}
	
}
