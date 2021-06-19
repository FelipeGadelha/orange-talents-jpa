package br.com.alura.jpa.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Transition;

public class JPQLTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Account account = new Account();
		account.setId(2L);
		
		String jpql = "select t from Transition t where t.account = :pAccount order by t.value desc ";
		
		TypedQuery<Transition> query = manager.createQuery(jpql, Transition.class);
		query.setParameter("pAccount", account);
		List<Transition> list = query.getResultList();
		
		list.forEach(t -> {
			System.out.println("Descrição: " + t.getDescription());
			System.out.println("Tipo: " + t.getTransitionType());
		});
	}
	
}
