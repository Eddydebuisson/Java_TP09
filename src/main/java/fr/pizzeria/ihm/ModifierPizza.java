package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizza extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	/**
	 * @param Constructeur de ModifierPizza avec en param�tre un PizzaDao
	 */
	public ModifierPizza(PizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "3. Mettre a jour une pizza";
	}

	@Override
	public boolean excute() {

		LOG.info("Tapez 99 pour annuler");
		LOG.info("Veuillez saisir le code de la Pizza � modifier");
		String codePizza = Menu.getSc().next();
		LOG.info("Veuillez saisir le code");
		String code = Menu.getSc().next();
		if (!code.equals("99")) {
			LOG.info("Veuillez saisir le nom (sans espace)");
			String nom = Menu.getSc().next();
			LOG.info("Veuillez saisir le prix");
			String prix = Menu.getSc().next();
			LOG.info("Veulliez indiquer la cat�gorie de la Pizza : VIANDE, SANS_VIANDE ou POISSON");
			String categorie = Menu.getSc().next();
			
			//instanciation Pizza
			Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix),CategoriePizza.valueOf(categorie));
			
			//sauvegarde Pizza
			dao.updatePizza(codePizza, pizza);
			

		}
		return true;

	}
}
