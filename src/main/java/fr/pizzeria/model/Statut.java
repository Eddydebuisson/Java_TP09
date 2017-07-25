package fr.pizzeria.model;

import javax.persistence.Enumerated;

public enum Statut {

	LIVRER("livrée"), EN_COURS("en cours"), ANNULER("annuler");
	@Enumerated
	private String value;

	private Statut(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}

}
