package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;

public abstract class OptionMenu {
	public PizzaDao dao; 

	/**
	 * @return
	 */
	public abstract String getLibelle();

	/**
	 * @return
	 * @throws UpdatePizzaException 
	 */
	public abstract boolean excute() throws UpdatePizzaException;
	
	/**
	 * @return
	 */
	public PizzaDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(PizzaDao dao) {
		this.dao = dao;
	}


}
