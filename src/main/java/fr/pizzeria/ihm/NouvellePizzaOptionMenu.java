package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
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

		LOG.info("Tapez 99 pour annuler");
		LOG.info("Veuillez saisir le code");

		String code = Menu.sc.next();
		if (!code.equals("99")) {

			LOG.info("Veuillez saisir le nom (sans espace)");
			String nom = Menu.sc.next();
			LOG.info("Veuillez saisir le prix");
			String prix = Menu.sc.next();
			LOG.info("Veulliez indiquer la catégorie de la Pizza : Viande, non viande ou poisson");
			String categorie= Menu.sc.next();
			
			// Instanciation pizza
			Pizza pizza =  new Pizza(code, nom, Double.parseDouble(prix),CategoriePizza.valueOf(categorie));
			
			// Sauvegarde pizza
			try {
				dao.saveNewPizza(pizza);
			} catch (SavePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
		}

		return true;
	}

}
