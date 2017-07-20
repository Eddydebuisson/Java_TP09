package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaDao {

	private PizzaDao dao;

	@Test
	public void tesPizzaInit() throws Exception {

		dao = new PizzaDao();
		List<Pizza> pizza = dao.findAllPizzas();
		assertTrue(pizza.contains(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)));
		assertTrue(pizza.contains(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE)));
		assertTrue(pizza.contains(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.POISSON)));
		assertTrue(pizza.contains(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE)));
		assertTrue(pizza.contains(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE)));
		assertTrue(pizza.contains(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE)));
		assertTrue(pizza.contains(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE)));
		assertTrue(pizza.contains(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.POISSON)));

	}

}
