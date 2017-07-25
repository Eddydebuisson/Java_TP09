package fr.pizzeria.ihm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class MenuTest {

	private Menu menu;

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


	@Test
	public void testMenu() throws Exception {
		menu = new Menu();
		menu.afficher();

		assertThat(systemOutRule.getLog()).contains("***** Pizzeria Administration *****");
		assertThat(systemOutRule.getLog()).contains("1.lister les pizza");
		assertThat(systemOutRule.getLog()).contains("2. Ajouter une nouvelle pizza");
		assertThat(systemOutRule.getLog()).contains("3. Mettre a jour une pizza");
		assertThat(systemOutRule.getLog()).contains("4. Supprimer une pizza");
		assertThat(systemOutRule.getLog()).contains("99. Sortie");

	}

}
