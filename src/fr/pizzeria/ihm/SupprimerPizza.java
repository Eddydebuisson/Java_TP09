package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public class SupprimerPizza extends OptionMenu {

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

		System.out.println("Tapez 99 pour annuler");
		System.out.println("Veuillez choisir la pizzza à modifier");
		String pizza = Menu.sc.next();
		
		dao.deletePizza(pizza);
		
		
		
		
		return true;
	}

}
