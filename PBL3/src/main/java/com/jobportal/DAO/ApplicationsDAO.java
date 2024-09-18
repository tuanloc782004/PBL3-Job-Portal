package com.jobportal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jobportal.model.Applications;

public class ApplicationsDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String INSERT_DATA = "INSERT INTO applications " + "(id_job, id_user, id_confirmation) VALUES "
			+ "(?,?,?);";
	private static final String SELECT_DATA = "select * from applications where id_job = ? and id_user = ?";
	private static final String DELETE_DATA = "delete from applications where id_job = ? and id_user = ?;";
	private static final String UPDATE_DATA = "update applications set id_confirmation = ? where id_job = ? and id_user = ?;";
	
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
	
	public boolean updateData(int idConfirmation, int idJob, int idUser) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DATA);) {
			statement.setInt(1, idConfirmation);
			statement.setInt(2, idJob);
			statement.setInt(3, idUser);
			
			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}
	
	public boolean deleteData(int idJob, int idUser) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DATA);) {
			statement.setInt(1, idJob);
			statement.setInt(2, idUser);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public Applications selectData(int idJob, int idUser) {
		Applications data = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATA);) {
			preparedStatement.setInt(1, idJob);
			preparedStatement.setInt(2, idUser);

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idJ = rs.getInt("id_job");
				int idU = rs.getInt("id_user");
				int idC = rs.getInt("id_confirmation");
				data = new Applications(idJ, idU, idC);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void insertData(Applications a) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);) {
			preparedStatement.setInt(1, a.getIdJob());
			preparedStatement.setInt(2, a.getIdUser());
			preparedStatement.setInt(3, a.getIdConfirmation());

			System.out.println(preparedStatement);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
