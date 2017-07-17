package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.dao.PizzaDao;

public class Menu {
	
	
	public PizzaDao dao;
	private Map<Integer, OptionMenu> menu = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * Instanciation de PizzaDao et du menu.
	 *  
	 */
	public Menu() {
		dao = new PizzaDao();
		menu.put(new Integer(0), new ListerPizzasOptionMenu(dao));
		menu.put(new Integer(1), new NouvellePizzaOptionMenu(dao));
		menu.put(new Integer(2), new ModifierPizza(dao));
		menu.put(new Integer(3), new SupprimerPizza(dao));

	}

	/**
	 * 
	 *  Afichage du menu complet.
	 * 
	 */
	public void afficher() {

		System.out.println("***** Pizzeria Administration *****");
		
		
		Set<Integer> keys = menu.keySet();
		for (Integer key: keys){
			System.out.println(menu.get(key).getLibelle());
		}

		System.out.println("99. Sortie");
	}

	/**
	 * 
	 *  Interface utilisateur
	 * 
	 */
	public void startMenu() {

		afficher();
		int reponse = -1;
		do {
			reponse = sc.nextInt();
			switch (reponse) {

			case 1:
				menu.get(0).excute();
				break;

			case 2:
				menu.get(1).excute();
				break;
			case 3:
				menu.get(2).excute();
				break;
			case 4:
				menu.get(3).excute();
				break;
			case 99:
				System.out.println("Aurevoir =( ");
				break;
			}
		} while (reponse != 99);

	}

}
