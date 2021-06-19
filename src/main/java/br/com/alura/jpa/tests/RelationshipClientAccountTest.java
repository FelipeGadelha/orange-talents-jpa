package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Client;

public class RelationshipClientAccountTest {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Account account = new Account();
		account.setId(1L);
		
		Client client = new Client();
		client.setName("João");
		client.setAddress("Rua do Rosário, 60");
		client.setWork("Professor");
		client.setAccount(account);
		
		manager.getTransaction().begin();
		manager.persist(client);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
