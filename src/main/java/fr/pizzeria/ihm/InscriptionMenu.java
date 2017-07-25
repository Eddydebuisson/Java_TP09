package fr.pizzeria.ihm;

import fr.pizzeria.dao.ClientDao;

public class InscriptionMenu extends OptionMenu {

	public InscriptionMenu(ClientDao dao) {
		this.dao2 = dao;
	}

	@Override
	public String getLibelle() {

		return "1. S'inscrire";
	}

	@Override
	public boolean excute() {
		// TODO Auto-generated method stub
		return true;
	}

}
