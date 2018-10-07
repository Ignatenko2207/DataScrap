package info.sjd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.sjd.entity.Item;

public class ItemDAO {

	public static Item save(Item item) {

		String sql = "INSERT INTO items (asin, name, price, item_link, item_group) VALUES(?,?,?,?,?)";

		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, item.getAsin());
			statement.setString(2, item.getName());
			statement.setInt(3, item.getPrice());
			statement.setString(4, item.getItemLink());
			statement.setString(5, item.getGroup());

			statement.executeUpdate();

			return item;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(statement, connection);
		}

		return null;
	}

	public static Item getOne(String asin) {

		Item item = null;
		
		String sql = "SELECT * FROM items WHERE asin=?";

		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, asin);
			
			rSet = statement.executeQuery();
			while (rSet.next()) {
				item = new Item();
				item.setAsin(rSet.getString("asin"));
				item.setName(rSet.getString("name"));
				item.setPrice(rSet.getInt("price"));
				item.setGroup(rSet.getString("item_group"));
				item.setItemLink(rSet.getString("item_link"));
				
				return item;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(rSet, statement, connection);
		}

		return item;
	}
}
