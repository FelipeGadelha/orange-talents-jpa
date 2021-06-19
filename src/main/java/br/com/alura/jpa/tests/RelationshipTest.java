package br.com.alura.jpa.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Transition;
import br.com.alura.jpa.model.TransitionType;

public class RelationshipTest {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Account account = new Account();
		account.setAgency(12341);
		account.setNumber(85765);
		account.setBalance(300.0);
		account.setHolder("Leonardo");
		
		
		Transition transition = new Transition();
		transition.setDate(LocalDateTime.now());
		transition.setDescription("Churrascaria");
		transition.setValue(new BigDecimal(200.0));
		transition.setTransitionType(TransitionType.IN);
		transition.setAccount(account);
		
		manager.getTransaction().begin();
		manager.persist(account);
		manager.persist(transition);
		manager.getTransaction().commit();
	}
}
