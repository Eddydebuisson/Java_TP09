package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.DeletePizzaException;

public class VerifSaisie {
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	public String verifCode() {

		boolean correct;
		// Boucle tant que le code entr� n'est pas bon
		do {
			correct = true;
			LOG.info("Tapez 99 pour annuler");
			LOG.info("Veuillez choisir la pizza � supprimer");
			String pizza = Menu.sc.next();
			try {
				if (!pizza.equals("99")) {
					// V�rifie que le code soit compos� de 3 lettres majuscules
					if (!pizza.matches("[A-Z]{3}")) {
						throw new DeletePizzaException("Veuillez saisir un code Correct");
					}

				} else {
					correct = true;
				}
			} catch (DeletePizzaException e) {
				System.err.println(e.getMessage());
				correct = false;
			}
		} while (!correct);

		return "";
	}

}
