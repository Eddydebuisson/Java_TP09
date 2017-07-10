package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	/**
	 * @param dao
	 *            constructeur NouvellePizzaOptionMenu
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

		boolean saisiecorrect = false;
		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez saisir le code");
		String code = Menu.sc.next();
		if (!code.equals("99")) {
			do {
				try {

					if (dao.findIndex(code) != -1 || code.matches("[A-Z][A-Z][A-Z]") == false)
						throw new SavePizzaException("Votre code existe déjà ou n'est pas dans le bon format.");

					System.out.println("Veuillez saisir le nom (sans espace)");
					String nom = Menu.sc.next();

					if (nom.isEmpty() == true)
						throw new SavePizzaException("Veillez saisir un nom de pizza");
					System.out.println("Veuillez saisir le prix");
					String prix = Menu.sc.next();
					if (prix.isEmpty() == true)
						throw new SavePizzaException("Veuillez saisir un prix.");
					System.out.println("Veulliez indiquer la catégorie de la Pizza : VIANDE, SANS_VIANDE ou POISSON");
					String categorie = Menu.sc.next();
					if (categorie.equals("VIANDE") == false || categorie.equals("SANS_VIANDE") == false
							|| categorie.equals("POISSON