package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaDao {

	private PizzaDao dao;

	@Test
	public void tesPizzaInit() throws Exception {

		dao = new PizzaDao();
		assertTrue(dao.findAllPizzas().contains(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.POISSON)));
		assertTrue(
				dao.findAllPizzas().contains(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.POISSON)));

	}

	@Test
	public void testFindPizza() throws Exception {
		dao = new PizzaDao();
		int trouver = dao.findIndex("PEP");
		assertEquals(0, trouver);
		int nonTrouver = dao.findIndex("LOL");
		assertEquals(-1, nonTrouver);
	}

	@Test
	public void testSavePizza() throws Exception {
		dao = new PizzaDao();
		dao.saveNewPizza(new Pizza(8, "CAT", "Freescis", 13.56, CategoriePizza.POISSON));
		assertTrue(dao.findAllPizzas().contains(new Pizza(8, "CAT", "Freescis", 13.56, CategoriePizza.POISSON)));
	}

	@Test
	public void testUpdatePizza() throws Exception {
		dao = new PizzaDao();
		dao.updatePizza("PEP", new Pizza(0, "CAT", "Freescis", 13.56, CategoriePizza.POISSON));
		assertFalse(dao.findAllPizzas().contains(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)));
		assertTrue(dao.findAllPizzas().contains(new Pizza(8, "CAT", "Freescis", 13.56, CategoriePizza.POISSON)));
	}

	@Test
	public void testDeletePizza() throws Exception {
		dao = new PizzaDao();
		dao.deletePizza("PEP");
		assertFalse(dao.findAllPizzas().contains(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)));

	}

}
