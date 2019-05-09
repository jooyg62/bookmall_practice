package bookshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BsUtil {

public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.1.104:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
		
	}
}
