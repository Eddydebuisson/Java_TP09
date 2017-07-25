package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaria-console-enum");

	public PizzaDaoJpa() {
		List<Pizza> listepizza = new ArrayList<>();
		listepizza.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listepizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.POISSON));
		listepizza.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listepizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listepizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON));

		EntityManager em1 = emf.createEntityManager();

		for (Pizza pizza : listepizza) {
			em1.getTransaction().begin();
			em1.persist(pizza);
			em1.getTransaction().commit();
		}
		em1.close();


	}

	public void PizzaDaoJpaClose() {
		emf.close();
	}

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException, SQLException {
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		em1.persist(pizza);
		em1.getTransaction().commit();
		em1.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.code=:unCodePizza", Pizza.class)
				.setParameter("unCodePizza", codePizza);
		Pizza p = query.getSingleResult();
		p.setCode(pizza.getCode());
		p.setCategorie(pizza.getCategorie());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		em1.getTransaction().commit();
		em1.close();
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.code=:unCodePizza", Pizza.class)
				.setParameter("unCodePizza", codePizza);
		Pizza p = query.getSingleResult();
		em1.remove(p);
		em1.getTransaction().commit();
		em1.close();

		return true;

	}


}
