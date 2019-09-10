package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import models.exceptions.MaterialNotFoundException;

public class MaterialCatalogDB implements MaterialCatalogInterface {

	@Override
	public void addMaterial(Material newMaterial) {
		String sql = "";
		if (newMaterial instanceof Book) {
			sql = "insert into materials (barcode,title,author,isbn,numberofpages,branch,type) values(?,?,?,?,?,?,'BOOK')";
		} else if (newMaterial instanceof DVD) {
			sql = "insert into materials (barcode,title,director,catalognumber,runningtime,licenced,branch,type) values(?,?,?,?,?,?,?,'DVD')";
		}

		try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
			try (PreparedStatement stm = conn.prepareStatement(sql)) {

				if (newMaterial instanceof Book) {
					Book newBook = (Book) newMaterial;
					stm.setString(1, newBook.getId());
					stm.setString(2, newBook.getTitle());
					stm.setString(3, newBook.getAuthor());
					stm.setString(4, newBook.getIsbn());
					stm.setInt(5, newBook.getNumberOfPages());
					stm.setString(6, "AnyTown Branch");

				}

				else if (newMaterial instanceof DVD) {
					DVD newDVD = (DVD) newMaterial;

					stm.setString(1, newDVD.getId());
					stm.setString(2, newDVD.getTitle());
					stm.setString(3, newDVD.getDirector());
					stm.setString(4, newDVD.getCatalogNumber());
					stm.setInt(5, newDVD.getRunningTime());
					stm.setBoolean(6, newDVD.getLicenced());
					stm.setString(7, "AnyTown Branch");
				}
				int results = stm.executeUpdate();
				System.out.println("Records added: " + results);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Map<String, Material> getMaterialMap() {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm.executeQuery("select * from materials")) {

						Map<String, Material> allMaterials = new LinkedHashMap<String, Material>();

						while (rs.next()) {
							String materialType = rs.getString("type");
							if (materialType.equalsIgnoreCase("BOOK")) {
								Book newBook = new Book(rs.getString("barcode"), rs.getString("title"),
										rs.getString("author"), rs.getString("branch"), rs.getString("isbn"),
										rs.getInt("numberofpages"));
								allMaterials.put(rs.getString("barcode"), newBook);
							} else if (materialType.equalsIgnoreCase("DVD")) {
								DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"),
										rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"),
										rs.getInt("runningtime"));
								allMaterials.put(rs.getString("barcode"), newDVD);
							}
						}
						return allMaterials;
					}
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Material findMaterial(String title) throws MaterialNotFoundException {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm
							.executeQuery("select * from materials where title like '%" + title + "%'")) {
						if (rs.next()) {
							String materialType = rs.getString("type");
							if (materialType.equalsIgnoreCase("BOOK")) {
								Book newBook = new Book(rs.getString("barcode"), rs.getString("title"),
										rs.getString("author"), rs.getString("branch"), rs.getString("isbn"),
										rs.getInt("numberofpages"));
								return newBook;
							} else if (materialType.equalsIgnoreCase("DVD")) {
								DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"),
										rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"),
										rs.getInt("runningtime"));
								return newDVD;
							} else {
								throw new MaterialNotFoundException();
							}
						} else {
							throw new MaterialNotFoundException();
						}
					}
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getNumberOfMaterials() {
		try {
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {

				try (Statement stm = conn.createStatement()) {

					try (ResultSet rs = stm.executeQuery("select count(id) from materials")) {
						rs.next();
						return rs.getInt(1);
					}
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
