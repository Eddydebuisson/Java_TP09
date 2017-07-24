package fr.pizzeria.model;

import javax.persistence.Enumerated;

public enum CategoriePizza {

	VIANDE("Viande"),SANS_VIANDE("Sans viande"),POISSON("Poisson");
	@Enumerated
	private String value;
	
	private CategoriePizza(String s){
		this.value = s;
	}
	
	public String getValue(){
		return value;
	}
	
	
}
