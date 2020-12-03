import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

class Oracle {
	Date day;
	String day_str;
	String category;
	String content;
	int income;
	int spending;
	
	public static Connection getConnection() {
			Connection conn = null;
			String myDriver ="oracle.jdbc.driver.OracleDriver";
			String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String myID = "jslhrd46";
			String myPass = "1234";
			
			try {
				Class.forName(myDriver);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(myURL, myID, myPass);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	

}

public class day22 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Oracle or = new Oracle();
		
		Connection conn = or.getConnection();
		String sql = "{call sp_salary(?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, "SCOTT");
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		cstmt.execute();
		
		int salary = cstmt.getInt(2);
		
		cstmt.setString("v_ename", "SCOTT");
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		System.out.println(salary);
		
//		String sql2 = "{call dept_inset(?,?,?,?)}";
//		CallableStatement cstmt2 = conn.prepareCall(sql2);
//		cstmt2.setInt(1, 60);
//		cstmt2.setString(2, "TESTPART");
//		cstmt2.setString(3, "DAEJEON");
//		cstmt2.registerOutParameter(4, java.sql.Types.INTEGER);
//		cstmt2.execute();
//		
//		int row = cstmt2.getInt(4);
//		System.out.println(row);
		
	}
}
