package fr.pizzeria.dao;

import java.sql.SQLException;
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
	 * @throws SQLException
	 */
	List<Pizza> findAllPizzas() throws SQLException;

	/**
	 * @param pizza
	 * @return
	 * @throws SQLException
	 */
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException, SQLException;

	/**
	 * @param codePizza
	 * @param pizza
	 * @return
	 * @throws SQLException
	 */
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException, SQLException;


	/**
	 * @param codePizza
	 * @return
	 * @throws SQLException
	 */
	boolean deletePizza(String codePizza) throws DeletePizzaException, SQLException;
	
	
	
	
	
	
	
	

}
