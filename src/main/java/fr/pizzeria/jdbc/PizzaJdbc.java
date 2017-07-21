package fr.pizzeria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJdbc implements IPizzaDao {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaJdbc.class);
	private Connection conn;
	private static final String MyDriver = "org.h2.Driver";
	private Statement statement;

	public Connection getConn() {
		return conn;
	}

	public PizzaJdbc() throws ClassNotFoundException, SQLException {
		initConnection();
		createtable();
		initTable();
	}

	public void initConnection() throws ClassNotFoundException, SQLException {
			Class.forName(MyDriver);
		String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
			String user = "sa";
		String Bd_pass = "";
		conn = DriverManager.getConnection(url, user, Bd_pass);
	}

	public void createtable() throws SQLException {

		String sql = "CREATE TABLE Pizza (" + " ID int NOT NULL AUTO_INCREMENT," + " code varchar(32) NOT NULL,"
				+ " Libelle varchar(32)," + " prix double(4)," + " categorie varchar(32) NOT NULL,"
				+ " PRIMARY KEY (ID));";
		statement.execute(sql);
	}

	public void initTable() throws SQLException {

		PreparedStatement ajoutPizza = conn
				.prepareStatement("INSERT INTO PIZZA(code, libelle, prix, categorie) VALUES ( ? , ? , ?, ? ) ");
		List<Pizza> listepizza = new ArrayList<>();
		listepizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listepizza.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.POISSON));
		listepizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listepizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listepizza.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE));
		listepizza.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.POISSON));

		for (Pizza p : listepizza) {
			ajoutPizza.setString(1, p.getCode());
			ajoutPizza.setString(2, p.getNom());
			ajoutPizza.setDouble(3, p.getPrix());
			ajoutPizza.setString(4, p.getCategorie().getValue());
			ajoutPizza.executeUpdate();
		}

	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		try {

			ResultSet resultats = statement.executeQuery("SELECT * FROM	PIZZA");
			while (resultats.next()) {
				Integer id = resultats.getInt("ID");
				String code = resultats.getString("code");
				String libelle = resultats.getString("libelle");
				Double prix = resultats.getDouble("prix");
				CategoriePizza categorie = CategoriePizza.valueOf(resultats.getString("categorie"));
				pizzas.add(new Pizza(id, code, libelle, prix, categorie));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

}
