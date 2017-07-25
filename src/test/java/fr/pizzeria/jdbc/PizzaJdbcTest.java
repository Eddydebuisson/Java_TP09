package fr.pizzeria.jdbc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJdbcTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private static Connection conn;
	private static Statement statement;
	private static PreparedStatement ajoutPizza;
	private PizzaJdbc jdbc;
	@BeforeClass
	public static void setUp() throws Exception {

		Class.forName("org.h2.Driver");
		String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
		String user = "sa";
		String Bd_pass = "";
		conn = DriverManager.getConnection(url, user, Bd_pass);
		statement = conn.createStatement();

		String sql = "CREATE TABLE Pizza (" + " ID int NOT NULL AUTO_INCREMENT,"
				+ " code varchar(32) NOT NULL,"
				+ " Libelle varchar(32)," + " prix double(4)," + " categorie varchar(32) NOT NULL,"
				+ " PRIMARY KEY (ID));";
		statement.execute(sql);
		ajoutPizza = conn
				.prepareStatement("INSERT INTO PIZZA(code, libelle, prix, categorie) VALUES ( ? , ? , ?, ? ) ");
	}

	@Test
	public void testConnection() throws Exception {
		assertThat(conn.isValid(0)).isEqualTo(true);
	}

	@Test
	public void TestInsertJdbc() throws SQLException {
		ajoutPizza.setString(1, "CAT");
		ajoutPizza.setString(2, "Délice à poils");
		ajoutPizza.setDouble(3, 9.99);
		ajoutPizza.setString(4, "VIANDE");

		int nbinserte = ajoutPizza.executeUpdate();
		assertEquals(1, nbinserte);

	}

	@Test
	public void InitPizza() throws Exception {
		ResultSet resultats = statement.executeQuery("SELECT * FROM	PIZZA");
		while (resultats.next()) {
			Integer id = resultats.getInt("ID");
			String code = resultats.getString("code");
			String libelle = resultats.getString("libelle");
			Double prix = resultats.getDouble("prix");
			String categorie = resultats.getString("categorie");
			System.out.println(id + " " + code + " " + libelle + " " + prix + " " + categorie);
		}

	}

	@Test
	public void testSavePizza() throws Exception {
		jdbc = new PizzaJdbc();
		Pizza p = new Pizza("DOG", "Chien", 12.00, CategoriePizza.VIANDE);
		jdbc.saveNewPizza(p);
		assertThat(jdbc.findAllPizzas()).contains(p);

	}

	@Test
	public void testUpdatePizza() throws Exception {
		jdbc = new PizzaJdbc();
		Pizza p = new Pizza("DOG", "Chien2", 12.00, CategoriePizza.VIANDE);
		jdbc.updatePizza("PEP", p);
		assertThat(jdbc.findAllPizzas()).contains(p);
	}

	@Test
	public void testDeletePizza() throws Exception {
		jdbc = new PizzaJdbc();
		Pizza p = new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		jdbc.deletePizza("PEP");
		assertThat(jdbc.findAllPizzas()).doesNotContain(p);
	}


}
