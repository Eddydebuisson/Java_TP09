package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"),SANS_VIANDE("Sans viande"),POISSON("Poisson");
	
	private String value;
	
	private CategoriePizza(String s){
		this.value = s;
	}
	
	public String getValue(){
		return value;
	}
	
	
}
