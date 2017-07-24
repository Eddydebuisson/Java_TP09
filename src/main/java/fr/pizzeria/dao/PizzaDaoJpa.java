package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaria-console-enum");
	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		EntityManager em2 = emf.createEntityManager();
		TypedQuery<Pizza> query = em2.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> resultList = query.getResultList();
		em2.close();
		return resultList;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException, SQLException {
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		em1.persist(pizza);
		em1.getTransaction().commit();
		em1.close();
		emf.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException {
		EntityManager em1 = emf.createEntityManager();
		TypedQuery<Pizza> query = em1.createQuery("select p from Pizza p where p.code=:unCodePizza", Pizza.class)
				.setParameter("unCodePizza", codePizza);

		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
