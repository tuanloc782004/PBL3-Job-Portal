package com.jobportal.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jobportal.model.Users;

public class UsersDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String INSERT_USERS_SQL = "INSERT INTO users " + "(uname, upwd, uemail, umobile) VALUES "
			+ "(?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "select id,uname,upwd,uemail,umobile from users where id=?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set uname = ?, upwd = ?, uemail = ?, umobile = ? where id = ?;";
	private static final String GET_USER_BY_EMAIL = "SELECT id, uname, upwd, umobile FROM users WHERE uemail = ?";
	//
	private static final String GET_DATA = "select u.* from users u inner join applications a on u.id = a.id_user where a.id_job = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_DATA_BY_KEY = "SELECT u.* " + "FROM users u "
			+ "INNER JOIN applications a ON u.id = a.id_user " + "WHERE u.uname LIKE ? " + "AND u.uemail LIKE ? "
			+ "AND a.id_job = ? " + "LIMIT ? OFFSET ?";
	private static final String COUNT_DATA = "select count(*) as total from users u inner join applications a on u.id = a.id_user WHERE a.id_job = ?";
	private static final String COUNT_DATA_BY_KEY = "SELECT COUNT(*) AS total "
			+ "FROM users u INNER JOIN applications a ON u.id = a.id_user "
			+ "WHERE u.uname LIKE ? AND u.uemail LIKE ? AND a.id_job = ?";
	
	private static final String GET_DATA_ADMIN = "select * from users"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_DATA_BY_KEY_ADMIN = "select * from users " + "WHERE uname LIKE ? " + "AND uemail LIKE ? "
			 + "LIMIT ? OFFSET ?";
	private static final String COUNT_DATA_ADMIN = "select count(*) as total from users";
	private static final String COUNT_DATA_BY_KEY_ADMIN = "SELECT COUNT(*) AS total from users "
			+ "WHERE uname LIKE ? AND uemail LIKE ?";
	private static final String COUNT = "select count(*) AS total from users";

	//
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
	
	public int count() {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					total = resultSet.getInt("total");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}
	
	public int countDataAdmin() {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_DATA_ADMIN)) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					total = resultSet.getInt("total");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public int countDataByKeyAdmin(String key) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_DATA_BY_KEY_ADMIN)) {

			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					total = resultSet.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public List<Users> getDataAdmin(int limit, int page) {
		List<Users> users = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DATA_ADMIN);) {
			
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("uname");
				String uemail = rs.getString("uemail");
				String upwd = rs.getString("upwd");
				String umobile = rs.getString("umobile");

				users.add(new Users(id, uname, upwd, uemail, umobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Users> getDataByKeyAdmin(String key, int limit, int page) {
		List<Users> users = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DATA_BY_KEY_ADMIN);) {

			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("uname");
				String uemail = rs.getString("uemail");
				String upwd = rs.getString("upwd");
				String umobile = rs.getString("umobile");

				users.add(new Users(id, uname, upwd, uemail, umobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int countData(int idJob) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_DATA)) {

			preparedStatement.setInt(1, idJob);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					total = resultSet.getInt("total");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public int countDataByKey(String key, int idJob) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_DATA_BY_KEY)) {

			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setInt(3, idJob);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					total = resultSet.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public List<Users> getData(int idJob, int limit, int page) {
		List<Users> users = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DATA);) {
			preparedStatement.setInt(1, idJob);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("uname");
				String uemail = rs.getString("uemail");
				String upwd = rs.getString("upwd");
				String umobile = rs.getString("umobile");

				users.add(new Users(id, uname, upwd, uemail, umobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Users> getDataByKey(String key, int idJob, int limit, int page) {
		List<Users> users = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DATA_BY_KEY);) {

			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setInt(3, idJob);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("uname");
				String uemail = rs.getString("uemail");
				String upwd = rs.getString("upwd");
				String umobile = rs.getString("umobile");

				users.add(new Users(id, uname, upwd, uemail, umobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	// get user by email
	public Users getUserByEmail(String email) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);) {
			try (PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL)) {
				statement.setString(1, email);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						Users user = new Users();
						user.setId(rs.getInt("id"));
						user.setUname(rs.getString("uname"));
						user.setUemail(email);
						user.setUpwd(rs.getString("upwd"));
						user.setUmobile(rs.getString("umobile"));
						return user;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// create or insert user
	public void insertUser(Users user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setString(1, user.getUname());
			preparedStatement.setString(2, user.getUpwd());
			preparedStatement.setString(3, user.getUemail());
			preparedStatement.setString(4, user.getUmobile());

			System.out.println(preparedStatement);

			preparedStatement.executeUpdate(); // Execute the SQL statement
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update user
	public boolean updateUser(Users user) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getUname());
			statement.setString(2, user.getUpwd());
			statement.setString(3, user.getUemail());
			statement.setString(4, user.getUmobile());
			statement.setInt(5, user.getId());

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	// select user by id
	public Users selectUser(int id) {
		Users user = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String uname = rs.getString("uname");
				String upwd = rs.getString("upwd");
				String uemail = rs.getString("uemail");
				String umobile = rs.getString("umobile");
				user = new Users(id, uname, upwd, uemail, umobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// select users
	public List<Users> selectAllUsers() {
		List<Users> users = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("uname");
				String upwd = rs.getString("upwd");
				String uemail = rs.getString("uemail");
				String umobile = rs.getString("umobile");
				users.add(new Users(id, uname, upwd, uemail, umobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	// delete users
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
