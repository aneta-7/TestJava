import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;

public class PersonRepository {

	private Connection conn;
	private Person personTemp;
	private Statement stmt;

	public PersonRepository(JdbcDataSource jdbcDataSource) throws SQLException {
		conn = jdbcDataSource.getConnection();
	}

	public Person findPersonByFirstName(String name) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "SELECT * FROM PERSON WHERE NAME LIKE '" + name + "';";
		ResultSet set = stmt.executeQuery(query);
		if (!set.next()) {
			personTemp = null;

		} else {
			personTemp = new Person();
			personTemp.setNAME(set.getString(2));
			personTemp.setLAST_NAME(set.getString(3));
		}
		return personTemp;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public Boolean addPerson(String name, String lastName, int age) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "INSERT INTO Person(NAME, LAST_NAME, AGE) VALUES ('" + name + "','" + lastName + "'," + age
				+ ");";
		int set = stmt.executeUpdate(query);

		if (set == 0)
			return false;

		else
			return true;
	}

	public Boolean updatePerson(String name, int age, String searchName) throws SQLException {
		stmt = null;
		stmt = conn.createStatement();
		String query = "UPDATE Person SET NAME ='" + name + "', AGE=" + age + " WHERE LAST_NAME ='" + searchName + "';";
		int set = stmt.executeUpdate(query);

		if (set == 0)
			return false;

		else
			return true;
	}

	public Boolean deletePerson(String id) throws SQLException{
		stmt = null;
		stmt = conn.createStatement();
		String query = "DELETE FROM Person WHERE NAME='" + id + "';";
		int set = stmt.executeUpdate(query);

		if (set == 0)
			return false;
		else
			return true;
	}
}
