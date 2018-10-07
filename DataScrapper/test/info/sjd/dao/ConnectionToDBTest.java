package info.sjd.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionToDBTest {

	@Test
	public void testGetConnection() {
		Connection connection = ConnectionToDB.getConnection();
		
		assertNotNull(connection);
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
