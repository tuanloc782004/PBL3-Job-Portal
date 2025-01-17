package com.jobportal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.model.Locations;

public class LocationsDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String SELECT_DATA_BY_ID = "select id, name from locations where id=?";
	private static final String SELECT_DATA_BY_NAME = "select id, name from locations where name=?";
	private static final String SELECT_ALL_DATA = "select * from locations";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public Locations selectDataById(int id) {
		Locations data = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATA_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				data = new Locations(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public Locations selectDataByName(String name) {
		Locations data = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATA_BY_NAME);) {
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				data = new Locations(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	// select users
	public List<Locations> getAll() {
		List<Locations> data = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DATA);) {

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				data.add(new Locations(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
