package fr.pizzeria.ihm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu{
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	/**
	 * @param dao contructeur de ListerPizzasOptionMenu
	 */
	public ListerPizzasOptionMenu(PizzaDao dao) {
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "1.lister les pizza";
	}

	@Override
	public boolean excute() {
		for (Pizza s : dao.findAllPizzas() ) {
			LOG.info(s.toString());
			}
		return true;
	}
	
	
	

}
