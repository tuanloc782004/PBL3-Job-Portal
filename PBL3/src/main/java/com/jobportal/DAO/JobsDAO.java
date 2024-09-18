package com.jobportal.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.jobportal.model.Jobs;

public class JobsDAO {

	public JobsDAO() {
		super();
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/jobportal?useSSl=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "782004tuanloc";

	private static final String COUNT = "select count(*) AS total from jobs";
	private static final String GET_ALL = "select * from jobs where id_display = 1" + " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_C = "select * from jobs where id_category = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_L = "select * from jobs where id_location = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_T = "select * from jobs where id_type = ? and id_display = 1" + " LIMIT ?"
			+ " OFFSET ?";
	private static final String GET_ALL_BY_CL = "select * from jobs where id_category = ? and id_location = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_CT = "select * from jobs where id_category = ? and id_type = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_LT = "select * from jobs where id_location = ? and id_type = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_CLT = "select * from jobs where id_category = ? and id_location = ? and id_type = ? and id_display = 1"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String COUNT_ALL = "select count(*) as total from jobs where id_display =1";
	private static final String COUNT_ALL_BY_C = "select count(*) as total from jobs where id_category = ? and id_display = 1";
	private static final String COUNT_ALL_BY_L = "select count(*) as total from jobs where id_location = ? and id_display = 1";
	private static final String COUNT_ALL_BY_T = "select count(*) as total from jobs where id_type = ? and id_display = 1";
	private static final String COUNT_ALL_BY_CL = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_display = 1";
	private static final String COUNT_ALL_BY_CT = "select count(*) as total from jobs where id_category = ? and id_type = ? and id_display = 1";
	private static final String COUNT_ALL_BY_LT = "select count(*) as total from jobs where id_location = ? and id_type = ? and id_display = 1";
	private static final String COUNT_ALL_BY_CLT = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_type = ? and id_display = 1";
	//
	private static final String GET_DATA_BY_ID = "select * from jobs where id=?";
	private static final String DELETE_DATA_BY_ID = "delete from jobs where id = ? and id_display = 1;";
	//
	private static final String GET_REC = "select * from jobs where id_recruiter = ?" + " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_C = "select * from jobs where id_category = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_L = "select * from jobs where id_location = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_T = "select * from jobs where id_type = ? and id_recruiter = ?" + " LIMIT ?"
			+ " OFFSET ?";
	private static final String GET_REC_BY_CL = "select * from jobs where id_category = ? and id_location = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_CT = "select * from jobs where id_category = ? and id_type = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_LT = "select * from jobs where id_location = ? and id_type = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_REC_BY_CLT = "select * from jobs where id_category = ? and id_location = ? and id_type = ? and id_recruiter = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String COUNT_REC = "select count(*) as total from jobs WHERE id_recruiter = ?";
	private static final String COUNT_REC_BY_C = "select count(*) as total from jobs where id_category = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_L = "select count(*) as total from jobs where id_location = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_T = "select count(*) as total from jobs where id_type = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_CL = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_CT = "select count(*) as total from jobs where id_category = ? and id_type = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_LT = "select count(*) as total from jobs where id_location = ? and id_type = ? and id_recruiter = ?";
	private static final String COUNT_REC_BY_CLT = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_type = ? and id_recruiter = ?";
	//
	private static final String INSERT_DATA = "INSERT INTO jobs "
			+ "(id_recruiter, id_category, id_location, id_type, salary, description, requirement, vacancy) VALUES "
			+ "(?,?,?,?,?,?,?,?);";
	private static final String UPDATE_DATA = "update jobs set id_category = ?,id_location = ?, id_type = ?, salary = ?, description = ?, requirement = ? , vacancy = ?  where id = ?;";
	private static final String UPDATE_DISPLAY = "update jobs set id_display = 1 where id = ?";
	private static final String UPDATE_DISPLAY_2 = "update jobs set id_display = 2 where id = ?";

	//
	private static final String GET_US = "select j.* from jobs j inner join applications a on j.id = a.id_job where a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_C = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_L = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_location = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_T = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_type = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_CL = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_location = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_CT = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_type = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_LT = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_location = ? and j.id_type = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_US_BY_CLT = "select j.* from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_location = ? and j.id_type = ? and a.id_user = ?"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String COUNT_US = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job WHERE a.id_user = ?";
	private static final String COUNT_US_BY_C = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and a.id_user = ?";
	private static final String COUNT_US_BY_L = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_location = ? and a.id_user = ?";
	private static final String COUNT_US_BY_T = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_type = ? and a.id_user = ?";
	private static final String COUNT_US_BY_CL = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_location = ? and a.id_user = ?";
	private static final String COUNT_US_BY_CT = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_type = ? and a.id_user = ?";
	private static final String COUNT_US_BY_LT = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_location = ? and j.id_type = ? and a.id_user = ?";
	private static final String COUNT_US_BY_CLT = "select count(*) as total from jobs j inner join applications a on j.id = a.id_job where j.id_category = ? and j.id_location = ? and j.id_type = ? and a.id_user = ?";
	//
	private static final String GET_ALL_ADMIN = "select * from jobs where id_display=0" + " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_C_ADMIN = "select * from jobs where id_category = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_L_ADMIN = "select * from jobs where id_location = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_T_ADMIN = "select * from jobs where id_type = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_CL_ADMIN = "select * from jobs where id_category = ? and id_location = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_CT_ADMIN = "select * from jobs where id_category = ? and id_type = ? and id_display =0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_LT_ADMIN = "select * from jobs where id_location = ? and id_type = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String GET_ALL_BY_CLT_ADMIN = "select * from jobs where id_category = ? and id_location = ? and id_type = ? and id_display = 0"
			+ " LIMIT ?" + " OFFSET ?";
	private static final String COUNT_ALL_ADMIN = "select count(*) as total from jobs where id_display=0";
	private static final String COUNT_ALL_BY_C_ADMIN = "select count(*) as total from jobs where id_category = ? and id_display = 0";
	private static final String COUNT_ALL_BY_L_ADMIN = "select count(*) as total from jobs where id_location = ? and id_display = 0";
	private static final String COUNT_ALL_BY_T_ADMIN = "select count(*) as total from jobs where id_type = ? and id_display = 0";
	private static final String COUNT_ALL_BY_CL_ADMIN = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_display = 0";
	private static final String COUNT_ALL_BY_CT_ADMIN = "select count(*) as total from jobs where id_category = ? and id_type = ? and id_display = 0";
	private static final String COUNT_ALL_BY_LT_ADMIN = "select count(*) as total from jobs where id_location = ? and id_type = ? and id_display = 0";
	private static final String COUNT_ALL_BY_CLT_ADMIN = "select count(*) as total from jobs where id_category = ? and id_location = ? and id_type = ? and id_display = 0";
	//
	private static final String sql = "SELECT MONTH(post_date) AS month, COUNT(*) AS job_count FROM jobs WHERE YEAR(post_date) = ? GROUP BY MONTH(post_date)";

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
	
	public List<Integer> getDistinctYears() {
        List<Integer> years = new ArrayList<>();
        TreeSet<Integer> yearSet = new TreeSet<>((y1, y2) -> Integer.compare(y2, y1));
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            String query = "SELECT DISTINCT YEAR(post_date) AS year FROM jobs ORDER BY year DESC";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int year = rs.getInt("year");
                yearSet.add(year);
            }
            
            years.addAll(yearSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return years;
    }

	public Map<String, Integer> getJobCountByMonth(int year) {
		Map<String, Integer> jobCountByMonth = new HashMap<>();

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, year);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int month = rs.getInt("month");
				int count = rs.getInt("job_count");
				jobCountByMonth.put(String.valueOf(month), count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jobCountByMonth;
	}

	public void insertData(Jobs job) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);) {

			preparedStatement.setInt(1, job.getIdRecruiter());
			preparedStatement.setInt(2, job.getIdCategory());
			preparedStatement.setInt(3, job.getIdLocation());
			preparedStatement.setInt(4, job.getIdType());
			preparedStatement.setString(5, job.getSalary());
			preparedStatement.setString(6, job.getDescription());
			preparedStatement.setString(7, job.getRequirement());
			preparedStatement.setInt(8, job.getVacancy());

			System.out.println(preparedStatement);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public boolean updateDisplay(int id) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DISPLAY);) {

			statement.setInt(1, id);

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	public boolean updateDisplay2(int id) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DISPLAY_2);) {

			statement.setInt(1, id);

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	public boolean updateData(Jobs job) throws SQLException {
		boolean rowUpdate;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DATA);) {

			statement.setInt(1, job.getIdCategory());
			statement.setInt(2, job.getIdLocation());
			statement.setInt(3, job.getIdType());
			statement.setString(4, job.getSalary());
			statement.setString(5, job.getDescription());
			statement.setString(6, job.getRequirement());
			statement.setInt(7, job.getVacancy());
			statement.setInt(8, job.getId());

			rowUpdate = statement.executeUpdate() > 0;
		}
		return rowUpdate;
	}

	public boolean deleteDataById(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DATA_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public Jobs getDataById(int id) {
		Jobs u = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DATA_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();
				u = new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement, vacancy,
						postDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public int countAllAdmin() {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_ADMIN);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				total = resultSet.getInt("total");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public int countAllByCAdmin(int c) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_C_ADMIN)) {

			preparedStatement.setInt(1, c);

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

	public int countAllByLAdmin(int l) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_L_ADMIN)) {

			preparedStatement.setInt(1, l);

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

	public int countAllByTAdmin(int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_T_ADMIN)) {

			preparedStatement.setInt(1, t);

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

	public int countAllByCLAdmin(int c, int l) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CL_ADMIN)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);

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

	public int countAllByCTAdmin(int c, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CT_ADMIN)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, t);

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

	public int countAllByLTAdmin(int l, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_LT_ADMIN)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, t);

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

	public int countAllByCLTAdmin(int c, int l, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CLT_ADMIN)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, t);

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

	public List<Jobs> getAllAdmin(int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ADMIN);) {
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCAdmin(int idC, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_C_ADMIN);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByLAdmin(int idL, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_L_ADMIN);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByTAdmin(int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_T_ADMIN);) {
			preparedStatement.setInt(1, idT);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCLAdmin(int idC, int idL, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CL_ADMIN);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCTAdmin(int idC, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CT_ADMIN);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByLTAdmin(int idL, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_LT_ADMIN);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCLTAdmin(int idC, int idL, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CLT_ADMIN);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idT);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public int countAll() {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				total = resultSet.getInt("total");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return total;
	}

	public int countAllByC(int c) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_C)) {

			preparedStatement.setInt(1, c);

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

	public int countAllByL(int l) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_L)) {

			preparedStatement.setInt(1, l);

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

	public int countAllByT(int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_T)) {

			preparedStatement.setInt(1, t);

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

	public int countAllByCL(int c, int l) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CL)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);

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

	public int countAllByCT(int c, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, t);

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

	public int countAllByLT(int l, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_LT)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, t);

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

	public int countAllByCLT(int c, int l, int t) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_BY_CLT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, t);

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

	public List<Jobs> getAll(int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);) {
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByC(int idC, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_C);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByL(int idL, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_L);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByT(int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_T);) {
			preparedStatement.setInt(1, idT);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCL(int idC, int idL, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CL);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCT(int idC, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByLT(int idL, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_LT);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getAllByCLT(int idC, int idL, int idT, int limit, int page) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_CLT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idT);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public int countRec(int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC)) {

			preparedStatement.setInt(1, idKey);

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

	public int countRecByC(int c, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_C)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, idKey);

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

	public int countRecByL(int l, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_L)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, idKey);

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

	public int countRecByT(int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_T)) {

			preparedStatement.setInt(1, t);
			preparedStatement.setInt(2, idKey);

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

	public int countRecByCL(int c, int l, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_CL)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, idKey);

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

	public int countRecByCT(int c, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_CT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, t);
			preparedStatement.setInt(3, idKey);

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

	public int countRecByLT(int l, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_LT)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, t);
			preparedStatement.setInt(3, idKey);

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

	public int countRecByCLT(int c, int l, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_REC_BY_CLT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, t);
			preparedStatement.setInt(4, idKey);

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

	public List<Jobs> getRec(int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC);) {
			preparedStatement.setInt(1, idKey);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByC(int idC, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_C);) {

			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByL(int idL, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_L);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByT(int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_T);) {
			preparedStatement.setInt(1, idT);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByCL(int idC, int idL, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_CL);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByCT(int idC, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_CT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByLT(int idL, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_LT);) {

			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getRecByCLT(int idC, int idL, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_REC_BY_CLT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idT);
			preparedStatement.setInt(4, idKey);
			preparedStatement.setInt(5, limit);
			preparedStatement.setInt(6, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public int countUs(int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US)) {

			preparedStatement.setInt(1, idKey);

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

	public int countUsByC(int c, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_C)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, idKey);

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

	public int countUsByL(int l, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_L)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, idKey);

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

	public int countUsByT(int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_T)) {

			preparedStatement.setInt(1, t);
			preparedStatement.setInt(2, idKey);

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

	public int countUsByCL(int c, int l, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_CL)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, idKey);

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

	public int countUsByCT(int c, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_CT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, t);
			preparedStatement.setInt(3, idKey);

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

	public int countUsByLT(int l, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_LT)) {

			preparedStatement.setInt(1, l);
			preparedStatement.setInt(2, t);
			preparedStatement.setInt(3, idKey);

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

	public int countUsByCLT(int c, int l, int t, int idKey) {
		int total = 0;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_US_BY_CLT)) {

			preparedStatement.setInt(1, c);
			preparedStatement.setInt(2, l);
			preparedStatement.setInt(3, t);
			preparedStatement.setInt(4, idKey);

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

	public List<Jobs> getUs(int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US);) {
			preparedStatement.setInt(1, idKey);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByC(int idC, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_C);) {

			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByL(int idL, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_L);) {
			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByT(int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_T);) {
			preparedStatement.setInt(1, idT);
			preparedStatement.setInt(2, idKey);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByCL(int idC, int idL, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_CL);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByCT(int idC, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_CT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByLT(int idL, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_LT);) {

			preparedStatement.setInt(1, idL);
			preparedStatement.setInt(2, idT);
			preparedStatement.setInt(3, idKey);
			preparedStatement.setInt(4, limit);
			preparedStatement.setInt(5, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

	public List<Jobs> getUsByCLT(int idC, int idL, int idT, int limit, int page, int idKey) {
		List<Jobs> jobs = new ArrayList<>();
		int offset = (page - 1) * limit;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_US_BY_CLT);) {
			preparedStatement.setInt(1, idC);
			preparedStatement.setInt(2, idL);
			preparedStatement.setInt(3, idT);
			preparedStatement.setInt(4, idKey);
			preparedStatement.setInt(5, limit);
			preparedStatement.setInt(6, offset);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idRecruiter = rs.getInt("id_recruiter");
				int idCategory = rs.getInt("id_category");
				int idLocation = rs.getInt("id_location");
				int idType = rs.getInt("id_type");
				String salary = rs.getString("salary");
				String description = rs.getString("description");
				String requirement = rs.getString("requirement");
				int vacancy = rs.getInt("vacancy");
				Timestamp timestamp = rs.getTimestamp("post_date");
				LocalDateTime postDate = timestamp.toLocalDateTime();

				jobs.add(new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement,
						vacancy, postDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

}
