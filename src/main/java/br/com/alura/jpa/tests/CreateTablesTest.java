package br.com.alura.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTablesTest {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		emf.close();
	}

}
