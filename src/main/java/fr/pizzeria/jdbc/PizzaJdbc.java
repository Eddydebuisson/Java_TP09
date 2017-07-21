package fr.pizzeria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaJdbc implements IPizzaDao {
	private static final Logger LOG = LoggerFactory.getLogger(PizzaJdbc.class);
	private Connection conn;
	private static final String MyDriver = "com.mysql.jdbc.Driver";
	private Statement statement;

	public Connection getConn() {
		return conn;
	}

	public PizzaJdbc() throws ClassNotFoundException, SQLException {
		initConnection();
		createtable();
	}

	public void initConnection() throws ClassNotFoundException, SQLException {
			Class.forName(MyDriver);
			String url = "jdbc:h2:nom:testdb";
			String user = "sa";
			String passwd = "";
			conn = DriverManager.getConnection(url, user, passwd);
	}

	public void createtable() throws SQLException {

		String sql = "CREATE TABLE Pizza (" + " ID int NOT NULL AUTO_INCREMENT," + " code varchar(32) NOT NULL,"
				+ " Libelle varchar(32)," + " prix double(4)," + " categorie varchar(32) NOT NULL,"
				+ " PRIMARY KEY (ID));";
		statement.execute(sql);

	}

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
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
