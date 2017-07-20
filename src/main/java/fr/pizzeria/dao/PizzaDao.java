package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {

	private List<Pizza> listepizza = new ArrayList<>();

	/**
	 * initialisation des pizzas avec le constructeur
	 */
	public PizzaDao() {

		listepizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));
		listepizza.add(new Pizza(1, "MAR", "Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(2, "REI", "La Reine", 11.50,CategoriePizza.POISSON));
		listepizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(4, "CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		listepizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		listepizza.add(new Pizza(6, "ORI", "L'orientale", 13.50,CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(7, "IND", "L'indienne", 14.00,CategoriePizza.POISSON));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listepizza;
	}

	/**
	 *
	 * regarde si la pizza existe déjà
	 * 
	 * @param a
	 * @return
	 */


	@Override
	public boolean saveNewPizza(Pizza pizza) {
		listepizza.add(pizza);

		return false;
	}

	/**
	 * @param codepizza
	 * @return -1 si la pizza n'éxiste pas sinon retourne l'index de la pizza
	 */
	public int findIndex(String codepizza) {
		int i = 0;
		for (Pizza p : listepizza) {
			if (p.getCode().equals(codepizza)) {
				return i;
			}
			i++;

		}
		return -1;

	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		if(findIndex(codePizza)!=-1){ 
		listepizza.set(findIndex(codePizza), pizza);
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {

		listepizza.remove(findIndex(codePizza));

		return false;
	}

}
