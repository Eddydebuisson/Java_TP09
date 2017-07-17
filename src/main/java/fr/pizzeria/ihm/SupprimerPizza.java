package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;

public class SupprimerPizza extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	/**
	 * @param dao
	 */
	public SupprimerPizza(PizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "4. Supprimer une pizza";
	}

	@Override
	public boolean excute() {

		LOG.info("Tapez 99 pour annuler");
		LOG.info("Veuillez choisir la pizzza à modifier");
		String pizza = Menu.sc.next();
		
		dao.deletePizza(pizza);
		
		
		
		
		return true;
	}

}
