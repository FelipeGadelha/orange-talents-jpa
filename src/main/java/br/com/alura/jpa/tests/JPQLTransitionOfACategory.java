package br.com.alura.jpa.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.model.Category;
import br.com.alura.jpa.model.Transition;

public class JPQLTransitionOfACategory {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager manager = emf.createEntityManager();
		
		Category category = new Category();
		category.setId(2L);
		
		
		String jpql = "select t from Transition t join t.categories c where c = :pCategory";
		
		TypedQuery<Transition> query = manager.createQuery(jpql, Transition.class);
		query.setParameter("pCategory", category);
		List<Transition> list = query.getResultList();
		
		list.forEach(t -> {
			System.err.println("--------------------------------------");
			System.err.println("Categorias: " + t.getCategories());
			System.err.println("Descrição: " + t.getDescription());
			System.err.println("Valor: " + t.getValue());
			System.err.println("Tipo: " + t.getTransitionType());
		});
		
		System.err.println("--------------------------------------");
		System.err.println("--------------------------------------");
		System.err.println("--------------------------------------");
		
//		Query query = 
//			    em.createQuery("select m from Movimentacao m join m.categoria c "
//			    		+ "where c = :pCategoria and m.valor > 500 "
//			    		+ "and m.tipoMovimentacao = :pTipoMovimentacao");
//			query.setParameter("pCategoria", viagem);
//			query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
//		------------------------------------------------------------------------
//		Category category2 = new Category();
//		category2.setId(1L);
//		
//		String jpql2 = "select t from Transition t join t.categories c "
//				+ "where c = :pCategory and t.value > 500 "
//				+ "and t.transitionType = :pTransitionType";
//		
//		TypedQuery<Transition> query2 = manager.createQuery(jpql, Transition.class);
//		query2.setParameter("pCategory", category2);
//		query2.setParameter("pTransitionType", TransitionType.OUT);
//		List<Transition> list2 = query2.getResultList();
//		
//		list2.forEach(t -> {
//			System.err.println("--------------------------------------");
//			System.err.println("Categorias: " + t.getCategories());
//			System.err.println("Descrição: " + t.getDescription());
//			System.err.println("Valor: " + t.getValue());
//			System.err.println("Tipo: " + t.getTransitionType());
//		});
		
	}
	
}
