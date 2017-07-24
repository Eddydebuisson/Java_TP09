package fr.pizzeria.jdbc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaJpa {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private PizzaDaoJpa jpa;

	@BeforeClass
	public static void setUp() throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaria-console-enum");
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		em1.persist(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));
		em1.getTransaction().commit();

		em1.close();

		// requete JPQL

		EntityManager em2 = emf.createEntityManager();

		TypedQuery<Pizza> query = em2.createQuery("select p from Pizza p", Pizza.class);
		query.getResultList().forEach(System.out::println);

		em2.close();

		emf.close();

	}

	@Test
	public void testBase() throws Exception {

	}

}
