import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
//	Database
//	Database Paradigm
//	1. SQL -> MySQL, SQL Server, PostgreSQL, SQLite, MariaDB
//		-> Structured Query Language
//	No SQL
//	2. Document -> MongoDB
//		-> JSON
//	3. In-Memory -> Redist, Memcache
//	4. Wide-Column -> Cassandra
//	5. Graph -> GraphQL
//	Dll
	
//	XAMPP
//	Cross Apache MariaDB php Perl
	
//	JDBC
//	Java Database Connectivity
	
	private DatabaseConnection db;
	Scanner scan = new Scanner(System.in);

	public Main() {
		// TODO Auto-generated constructor stub
		db = new DatabaseConnection();
		
		try {
			db.resultSet = db.getStudentsData();
			
			System.out.println("Column count " + db.resultSetMetaData.getColumnCount());
			System.out.println(db.resultSetMetaData.getTableName(1));
			while (db.resultSet.next()) {
				System.out.println(String.valueOf(db.resultSet.getObject(1)));
				System.out.println(String.valueOf(db.resultSet.getObject(2)));
				System.out.println(String.valueOf(db.resultSet.getObject(3)));
				System.out.println(String.valueOf(db.resultSet.getObject(4)));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		insertNewStudent();
		
	}
	
	public void insertNewStudent() {
		String name, gender;
		int age;
		
		System.out.print("Insert student name: ");
		name = scan.nextLine();
		
		System.out.print("Insert student age: ");
		age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Insert student gender[Male|Female]: ");
		gender = scan.nextLine();
		
		db.insertNewStudent(name, age, gender);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
