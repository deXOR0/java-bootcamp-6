import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class DatabaseConnection {
	
	public Connection connection;
	public Statement statement;
	public ResultSet resultSet;
	public ResultSetMetaData resultSetMetaData;
	public PreparedStatement preparedStatement;

	public DatabaseConnection() {
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/bootcamp", "root", "");
//			url database, username phpmyadmin, password phpmyadmin
			
			statement = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet execQuery(String query) {
		try {
			resultSet = statement.executeQuery(query);
			resultSetMetaData = resultSet.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public ResultSet getStudentsData() {
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM students");
			
			resultSet = preparedStatement.executeQuery();
			resultSetMetaData = resultSet.getMetaData();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void insertNewStudent(String name, int age, String gender) {
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO `students` (`name`, `age`, `gender`)"
							+ "VALUES (?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, gender);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
