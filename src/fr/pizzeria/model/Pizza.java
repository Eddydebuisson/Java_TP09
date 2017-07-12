package fr.pizzeria.model;

public class Pizza {

	int id;
	String code;
	String nom;
	Double prix;
	CategoriePizza categorie;
	
	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(int id, String code, String nom, Double prix,CategoriePizza categorie){
		
		this.id = id;
		this.code=code;
		this.nom=nom;
		this.prix=prix;
		this.categorie=categorie;
	}
	
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, Double prix,CategoriePizza categorie){
	
		this.code=code;
		this.nom=nom;
		this.prix=prix;
		this.categorie= categorie;
		
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return  code + " -> " + nom + "(" + prix + ") " + categorie.getValue() ;
	}
	
	
	
	
}
