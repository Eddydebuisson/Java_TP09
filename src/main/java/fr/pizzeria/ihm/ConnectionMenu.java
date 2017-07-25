package fr.pizzeria.ihm;

import fr.pizzeria.dao.ClientDao;

public class ConnectionMenu extends OptionMenu {



	public ConnectionMenu(ClientDao dao) {
		this.dao2 = dao;
	}

	@Override
	public String getLibelle() {
		return "2. Se connecter";
	}

	@Override
	public boolean excute() {
		return false;
	}

}
