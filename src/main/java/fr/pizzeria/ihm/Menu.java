package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;

public class Menu {
	
	
	private static final int Numero_sortie = 99;
	public PizzaDao dao;
	private Map<Integer, OptionMenu> menu = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);
	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);
	/**
	 * 
	 * Instanciation de PizzaDao et du menu.
	 *  
	 */
	public Menu() {
		dao = new PizzaDao();
		menu.put(new Integer(1), new ListerPizzasOptionMenu(dao));
		menu.put(new Integer(2), new NouvellePizzaOptionMenu(dao));
		menu.put(new Integer(3), new ModifierPizza(dao));
		menu.put(new Integer(4), new SupprimerPizza(dao));

	}

	/**
	 * 
	 *  Afichage du menu complet.
	 * 
	 */
	public void afficher() {

		LOG.info("***** Pizzeria Administration *****");
		
		Set<Integer> keys = menu.keySet();
		for (Integer key: keys){
			LOG.info(menu.get(key).getLibelle());
		}

		LOG.info("99. Sortie");
	}

	/**
	 * 
	 *  Interface utilisateur
	 * 
	 */
	public void startMenu() {

		afficher();
		int reponse = Numero_sortie;
		do {
			reponse = sc.nextInt();
			menu.get(reponse).excute();
		} while (reponse != Numero_sortie);

	}

}
