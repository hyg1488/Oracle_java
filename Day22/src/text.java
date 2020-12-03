import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

class tester{
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
public class text {
	public static void main(String[] args) throws Exception{
		tester or = new tester();
		Scanner sc = new Scanner(System.in);
		Connection conn = or.getConnection();
		String sql = "{call sp_salary(?,?,?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		String query = "select count(*) from department";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		int dno;
		int cnt = 0;
		while(rs.next()) {
			cnt = rs.getInt(1);
		}
		cnt = cnt*10;
		
		while(true) {
			int suc = 0;
			System.out.print("부서번호 : ");
			dno = sc.nextInt();
			for (int i = 10; i <= cnt; i=i+10) {
				if(dno == i) {
					suc = 1;
				}
			}
			
			if(dno == 0) {
				break;
			}else if(suc == 1) {
				
			}else if(suc == 0) {
				System.out.println("부서번호를 다시 확인하세요.");
				continue;
			}
			
			cstmt.setInt(1, dno);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println("부서번호\t부서명\t\t지역명");
			System.out.print(cstmt.getInt(2)+"\t");
			if(cstmt.getString(3).length()<7)
			System.out.print(cstmt.getString(3)+"\t\t");
			else System.out.print(cstmt.getString(3)+"\t");

			System.out.print(cstmt.getString(4)+"\t");
			System.out.println();
		}
		
	
	}
}
