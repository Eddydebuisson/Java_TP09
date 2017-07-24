package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;

public class Menu {
	
	
	private static final int NUMEROSORTIE = 99;
	private PizzaDao dao;
	private Map<Integer, OptionMenu> listeMenu = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);

	public static Scanner getSc() {
		return sc;
	}

	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);
	/**
	 * 
	 * Instanciation de PizzaDao et du menu.
	 *  
	 */
	public Menu() {
		dao = new PizzaDao();
		listeMenu.put(1, new ListerPizzasOptionMenu(dao));
		listeMenu.put(2, new NouvellePizzaOptionMenu(dao));
		listeMenu.put(3, new ModifierPizza(dao));
		listeMenu.put(4, new SupprimerPizza(dao));

	}

	/**
	 * 
	 *  Afichage du menu complet.
	 * 
	 */
	public void afficher() {

		LOG.info("***** Pizzeria Administration *****");
		
		Set<Integer> keys = listeMenu.keySet();
		for (Integer key: keys){
			LOG.info(listeMenu.get(key).getLibelle());
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
		int reponse;
		do {
			reponse = sc.nextInt();
			listeMenu.get(reponse).excute();
		} while (reponse != NUMEROSORTIE);

	}

}
