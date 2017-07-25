package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.ClientDao;

public class MenuClient {

	private static final int NUMEROSORTIE = 99;
	private ClientDao dao;
	private Map<Integer, OptionMenu> listeMenu = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	private static final Logger LOG = LoggerFactory.getLogger(Menu.class);

	/**
	 * 
	 * Instanciation de PizzaDao et du menu.
	 *  
	 */
	public MenuClient() {
		dao = new ClientDao();
		listeMenu.put(1, new InscriptionMenu(dao));
		listeMenu.put(2, new ConnectionMenu(dao));

	}

	/**
	 * 
	 * Afichage du menu complet.
	 * 
	 */
	public void afficher() {

		LOG.info("***** Pizzeria Client *****");

		Set<Integer> keys = listeMenu.keySet();
		for (Integer key : keys) {
			LOG.info(listeMenu.get(key).getLibelle());
		}

		LOG.info("99. Sortie");
	}

	/**
	 * 
	 * Interface utilisateur
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
