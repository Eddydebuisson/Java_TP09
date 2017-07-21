package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

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

		boolean correct;
		// Boucle tant que le code entré n'est pas bon
		do {
			correct = true;
			LOG.info("Tapez 99 pour annuler");
			LOG.info("Veuillez choisir la pizza à supprimer");
			String pizza = Menu.getSc().next();
			try {
				if (!pizza.equals("99")) {
				// Vérifie que le code soit composé de 3 lettres majuscules
				if (!pizza.matches("[A-Z]{3}")) {
					throw new DeletePizzaException("Veuillez saisir un code Correct");
				}
				dao.deletePizza(pizza);
				} else {
					correct = true;
				}
			} catch (DeletePizzaException e) {
				LOG.info(e.getMessage());
				correct = false;
			}
		} while (!correct);
		
		return true;
	}
		
		
		
	}


