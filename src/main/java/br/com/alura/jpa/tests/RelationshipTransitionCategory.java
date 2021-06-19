package br.com.alura.jpa.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Category;
import br.com.alura.jpa.model.Transition;
import br.com.alura.jpa.model.TransitionType;

public class RelationshipTransitionCategory {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		
		Category category = new Category("Viagem");		
		Category category2 = new Category("Negócio");
		
		Account account = new Account();
		account.setId(2L);
		
		Transition transition = new Transition();
		transition.setDescription("Viagem à SP");
		transition.setTransitionType(TransitionType.OUT);
		transition.setDate(LocalDateTime.now());
		transition.setValue(new BigDecimal(300.0));
		transition.setCategories(Arrays.asList(category, category2));
		transition.setAccount(account);
		
		Transition transition2 = new Transition();
		transition2.setDescription("Viagem à RJ");
		transition2.setTransitionType(TransitionType.OUT);
		transition2.setDate(LocalDateTime.now());
		transition2.setValue(new BigDecimal(400.0));
		transition2.setCategories(Arrays.asList(category, category2));
		transition2.setAccount(account);
		
		manager.getTransaction().begin();
		manager.persist(category);
		manager.persist(category2);
		manager.persist(transition);
		manager.persist(transition2);
		manager.getTransaction().commit();
		manager.close();
	}

}
