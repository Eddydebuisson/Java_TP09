package fr.pizzeria.jdbc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.dao.PizzaDaoJpa;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJpaTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private static PizzaDaoJpa jpa;

	@BeforeClass
	public static void setUp() throws Exception {
		jpa = new PizzaDaoJpa();
	}


	@Test
	public void testSavePizza() throws Exception {
		Pizza p = new Pizza("DOG", "Chien", 12.00, CategoriePizza.VIANDE);
		jpa.saveNewPizza(p);
		assertThat(jpa.findAllPizzas()).contains(p);

	}

	@Test
	public void testUpdatePizza() throws Exception {
		Pizza p = new Pizza("DOG", "Chien2", 12.00, CategoriePizza.VIANDE);
		jpa.updatePizza("PEP", p);
		assertThat(jpa.findAllPizzas()).contains(p);
	}

	@Test
	public void testDeletePizza() throws Exception {
		Pizza p = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		jpa.deletePizza("MAR");
		assertThat(jpa.findAllPizzas()).doesNotContain(p);
	}



}
