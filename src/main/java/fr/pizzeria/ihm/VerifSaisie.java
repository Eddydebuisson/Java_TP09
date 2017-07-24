package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.DeletePizzaException;

public class VerifSaisie {
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	public String verifCode() {
		Scanner sc = new Scanner(System.in);
		boolean correct;
		// Boucle tant que le code entré n'est pas bon
		do {
			correct = true;
			LOG.info("Tapez 99 pour annuler");
			LOG.info("Veuillez choisir la pizza à supprimer");
			String pizza = sc.next();
			try {
				if (!pizza.equals("99")) {
					// Vérifie que le code soit composé de 3 lettres majuscules
					if (!pizza.matches("[A-Z]{3}")) {
						throw new DeletePizzaException("Veuillez saisir un code Correct");
					}

				} else {
					correct = true;
				}
			} catch (DeletePizzaException e) {
				LOG.debug(e.getMessage());
				correct = false;
			}
		} while (!correct);

		return "";
	}

}
