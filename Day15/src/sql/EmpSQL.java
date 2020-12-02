package sql;

import java.sql.*;

import oracle.db.DBManager;

public class EmpSQL {
	DBManager manager = DBManager.getInstance();
	Connection conn = null;
	Statement stmt = null;	// 재활용 x 다시 선언해야 사용가능
	ResultSet rs = null;
	
	PreparedStatement pstmt = null;	// 재활용 가능
	
	public void exam_02(String name) {
		String query ="select * from employee where ename like '%"+name+"%'";
		try {
			conn = manager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println(name+"을 포함한 정보");
			while(rs.next()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.println(rs.getInt("salary"));
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void exam_02(int num, String name, int n) {
		String query ="select * from employee where salary>="+num;
		String pstmtquery ="select * from employee where dno = ? or job=?";
		// PreparedStatement ? 를 사용
		try {
			conn = manager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			pstmt = conn.prepareStatement(pstmtquery);
			pstmt.setInt(1, n);
			pstmt.setString(2, name);
			System.out.println("stmt 를 이용");
			while(rs.next()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.println(rs.getInt("salary"));
			}
			System.out.println();
			System.out.println("pstmt 를 이용");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.println(rs.getInt("salary"));
			}
			
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 필요한 메서드 정의
	// employee 테이블에서 급여 1500 이상 출력
	public void exam_01(int num) {
		String query ="select * from employee where salary>="+num;
		try {
			conn = manager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.print(rs.getInt("eno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.println(rs.getInt("salary"));
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
		public void exam_01(int n,String job) {
			String query ="select * from employee where dno ="+n+" or job='"+job+"'";
			try {
				conn = manager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					System.out.print(rs.getInt("eno")+"\t");
					System.out.print(rs.getString("ename")+"\t");
					if(rs.getString("job").length() <=7){
						System.out.print(rs.getString("job")+"\t\t");
					}else {
						System.out.print(rs.getString("job")+"\t");
					}
					System.out.print(rs.getInt("salary"));
					System.out.println(rs.getInt("dno"));

				}
				System.out.println();
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
			
			public void exam_01(String name) {
				String query ="select * from employee where ename='"+name+"'";
				try {
					conn = manager.getConnection();
					stmt = conn.createStatement();
					rs = stmt.executeQuery(query);
					while(rs.next()) {
						System.out.print(rs.getInt("eno")+"\t");
						System.out.print(rs.getString("ename")+"\t");
						System.out.print(rs.getInt("salary")+"\t");
					}
					System.out.println();
				}catch(Exception e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}finally {
					try {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
	}
}
