package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTesting {

	public static void main(String[] args) {

		RetrieveResultSet("Select title from materials");

	}

	public static void ChangeData(String sql, String title, int id) {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {

				try (PreparedStatement stm = conn.prepareStatement(sql)) {
					stm.setString(1, title);
					stm.setInt(2, id);
					int results = stm.executeUpdate();
					System.out.println("Records amended: " + results);
				}
			}

		} catch (SQLException e) {
			System.out.println("Something went wrong!");
			System.out.println(e);
		}
	}

	public static void RetrieveResultSet(String sql) {

		try {
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm.executeQuery(sql)) {
						while (rs.next()) {
							System.out.println(rs.getString("title"));
						}
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("Something went wrong!");
			System.out.println(e);
		}
	}
}
