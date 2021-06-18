package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class StatesTest {
	public static void main(String[] args) {
		//Transient
		Account account = new Account();
		account.setHolder("Almiro");
		account.setAgency(123321);
		account.setNumber(12354563);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		//Transient -> Managed
		manager.persist(account);
		
		manager.remove(account);
		manager.getTransaction().commit();
	}
}
