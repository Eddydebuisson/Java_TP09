package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizza extends OptionMenu {

	/**
	 * @param Constructeur de ModifierPizza avec en paramètre un PizzaDao
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

		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez saisir le code de la Pizza à modifier");
		String codePizza = Menu.sc.next();
		System.out.println("Veuillez saisir le code");
		String code = Menu.sc.next();
		if (!code.equals("99")) {
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = Menu.sc.next();
			System.out.println("Veuillez saisir le prix");
			String prix = Menu.sc.next();
			System.out.println("Veulliez indiquer la catégorie de la Pizza : Viande, non viande ou poisson");
			String categorie= Menu.sc.next();
			
			//instanciation Pizza
			Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix),CategoriePizza.valueOf(categorie));
			
			//sauvegarde Pizza
			dao.updatePizza(codePizza, pizza);
			

		}
		return true;

	}
}
