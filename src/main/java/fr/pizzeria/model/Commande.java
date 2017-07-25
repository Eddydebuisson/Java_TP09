package fr.pizzeria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_commande")
	private Integer NumeroDeCommande;
	@Column(name = "date_commande")
	private Date dateCommande;
	@Column(name="statut")
	private Statut statut;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur idLivreur;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client idClient;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizza;

	public Commande() {
		super();
	}

}
