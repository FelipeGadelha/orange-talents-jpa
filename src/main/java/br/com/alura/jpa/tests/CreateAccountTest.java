package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class CreateAccountTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Account account = new Account();
		account.setHolder("Márcia");
		account.setNumber(12334);
		account.setAgency(43221);
		account.setBalance(100.0);
		
		manager.getTransaction().begin();
		manager.persist(account);
		manager.getTransaction().commit();
		
		manager.close();
		
		EntityManager manager2 = emf.createEntityManager();
		System.out.println("ID da Conta da Márcia: " + account.getId());
		account.setBalance(500.0);
		
		manager2.getTransaction().begin();
		manager2.merge(account);
		manager2.getTransaction().commit();
		
	}
	
}
