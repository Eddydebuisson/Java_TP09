package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY8
 *
 */

public interface IPizzaDao {

	/**
	 * @return
	 */
	List<Pizza> findAllPizzas();

	/**
	 * @param pizza
	 * @return
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

	/**
	 * @param codePizza
	 * @param pizza
	 * @return
	 */
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;


	/**
	 * @param codePizza
	 * @return
	 */
	boolean deletePizza(String codePizza) throws DeletePizzaException; 
	
	
	
	
	
	
	
	

}
