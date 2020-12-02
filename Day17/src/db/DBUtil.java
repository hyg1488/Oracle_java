package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		String myDriver ="oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myId = "jslhrd46";
		String myPw = "1234";
		

		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myURL, myId, myPw);
			
		}catch(Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		
		return conn;
	}
}
