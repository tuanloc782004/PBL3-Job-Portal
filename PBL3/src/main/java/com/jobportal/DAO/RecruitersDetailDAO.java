package com.jobportal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jobportal.model.RecruitersDetail;

public class RecruitersDetailDAO {
	
	public RecruitersDetailDAO () {
		super();
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String INSERT_USERS_SQL = "INSERT INTO recruiters_detail " + "(id_recruiter, description,id_country,web,img) VALUES "
			+ "(?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "select id_recruiter,description,id_country,web,img from recruiters_detail where id_recruiter=?";
	private static final String UPDATE_USERS_SQL = "update recruiters_detail set description = ?, id_country = ?, web = ?,img = ?  where id_recruiter = ?;";

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

	// create or insert user
	public void insertRecruiter(RecruitersDetail user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setInt(1, user.getIdRecruiter());
			preparedStatement.setString(2, user.getDescription());
			preparedStatement.setInt(3, user.getIdCountry());
			preparedStatement.setString(4, user.getWeb());
			preparedStatement.setString(5, user.getImg());
			

			System.out.println(preparedStatement);

			preparedStatement.executeUpdate(); // Execute the SQL statement
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update user
	public boolean updateRecruiter(RecruitersDetail user) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
		
			statement.setString(1, user.getDescription());
			statement.setInt(2, user.getIdCountry());
			statement.setString(3, user.getWeb());
			statement.setString(4, user.getImg());
			statement.setInt(5, user.getIdRecruiter());

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	// select user by id
	public RecruitersDetail selectRecruiterDetail(int id) {
		RecruitersDetail userDetail = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String description = rs.getString("description");
				int idCountry = rs.getInt("id_country");
				String web = rs.getString("web");
				String img = rs.getString("img");
				userDetail = new RecruitersDetail(id, description, idCountry, web,img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDetail;
	}

}
