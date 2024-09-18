package com.jobportal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jobportal.model.UsersDetail;

public class UsersDetailDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String INSERT_USERS_SQL = "INSERT INTO users_detail " + "(id_user, id_category,id_location,work_experience,education,professional_skills,img) VALUES "
			+ "(?,?,?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "select id_user,id_category,id_location,work_experience,education,professional_skills,img from users_detail where id_user=?";
	private static final String UPDATE_USERS_SQL = "update users_detail set id_category = ?, id_location = ?, work_experience = ?, education = ?,professional_skills=?,img = ?  where id_user = ?;";

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
	public void insertUser(UsersDetail user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setInt(1, user.getIdUser());
			preparedStatement.setInt(2, user.getIdCategory());
			preparedStatement.setInt(3, user.getIdLocation());
			preparedStatement.setString(4, user.getWorkExperience());
			preparedStatement.setString(5, user.getEducation());
			preparedStatement.setString(6, user.getProfessionalSkills());
			preparedStatement.setString(7, user.getImg());
			

			System.out.println(preparedStatement);

			preparedStatement.executeUpdate(); // Execute the SQL statement
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update user
	public boolean updateUser(UsersDetail user) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setInt(1, user.getIdCategory());
			statement.setInt(2, user.getIdLocation());
			statement.setString(3, user.getWorkExperience());
			statement.setString(4, user.getEducation());
			statement.setString(5, user.getProfessionalSkills());
			statement.setString(6, user.getImg());
			statement.setInt(7, user.getIdUser());

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	// select user by id
	public UsersDetail selectUserDetail(int id) {
		UsersDetail userDetail = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				String workExperience = rs.getString("work_experience");
				String education = rs.getString("education");
				String professionalSkills = rs.getString("professional_skills");
				String img = rs.getString("img");
				userDetail = new UsersDetail(id, idCategory, idLocation, workExperience, education, professionalSkills, img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDetail;
	}

}
