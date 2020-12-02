package oracle.db;

import java.sql.*;

public class DBManager {	//싱글톤
	private DBManager() {
		
	}
	
	private static DBManager instance = new DBManager();
	
	public static DBManager getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		Connection myConn = null;
		String myDriver ="oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myId = "jslhrd46";
		String myPw = "1234";
		

		try {
			Class.forName(myDriver);
			myConn = DriverManager.getConnection(myURL, myId, myPw);
		}catch(Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		
		return myConn;
	}
	
}
