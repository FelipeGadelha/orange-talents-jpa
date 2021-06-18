package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class AlterBalanceAccountLeonardo {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();

		Account account = manager.find(Account.class, 1L);
		manager.getTransaction().begin();
		account.setBalance(20.0);
		manager.getTransaction().commit();
		
	}
	
	

}
