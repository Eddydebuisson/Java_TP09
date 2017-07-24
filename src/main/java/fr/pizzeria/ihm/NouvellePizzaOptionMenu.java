package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);
	/**
	 * @param dao constructeur NouvellePizzaOptionMenu
	 */
	public NouvellePizzaOptionMenu(PizzaDao dao) {
		this.dao = dao;
		
	}

	@Override
	public String getLibelle() {
		return "2. Ajouter une nouvelle pizza";
	}

	@Override
	public boolean excute() {
		Scanner sc = new Scanner(System.in);
		LOG.info("Tapez 99 pour annuler");
		LOG.info("Veuillez saisir le code");

		String code = sc.next();
		if (!code.equals("99")) {

			LOG.info("Veuillez saisir le nom (sans espace)");
			String nom = sc.next();
			LOG.info("Veuillez saisir le prix");
			String prix = sc.next();
			LOG.info("Veulliez indiquer la catégorie de la Pizza : VIANDE, SANS_VIANDE ou POISSON");
			String categorie = sc.next();
			
			// Instanciation pizza
			Pizza pizza =  new Pizza(code, nom, Double.parseDouble(prix),CategoriePizza.valueOf(categorie));
			
			// Sauvegarde pizza
				dao.saveNewPizza(pizza);
		
		}

		return true;
	}

}
