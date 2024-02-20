package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

// Connect to database MySQL
public class MyConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamemarket", "root", "171410Tn");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
