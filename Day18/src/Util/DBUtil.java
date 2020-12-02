package Util;

import java.sql.*;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		String myDriver ="oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jslhrd46";
		String myPass = "1234";
		
		
		try {
			Class.forName(myDriver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(myURL,myID, myPass);
		}catch(SQLException d){
			d.printStackTrace();
		}
		
		return conn;
		
	}
}
