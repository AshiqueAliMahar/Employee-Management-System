 package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesManagement", "root", "hp15p251nz");
			System.out.println("Connected");
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver Not Found");
		} catch (SQLException ex) {
			System.out.println("URL Mistake");
		}
		return con;
	}
}
//Driver:oracle.jdbc.driver.OracleDriver
//url:jdbc:oracle:thin:@//localhost:1521/orcl
//user name:scott