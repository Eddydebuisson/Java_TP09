package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public abstract class OptionMenu {
	public PizzaDao dao; 

	/**
	 * @return
	 */
	public abstract String getLibelle();

	/**
	 * @return
	 */
	public abstract boolean excute();
	
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
