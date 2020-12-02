package Exam;

import java.sql.*;

import oracle.db.DBManager;

public class EmpExam {
		DBManager manager = DBManager.getInstance();
		Connection conn = null;
		Statement stmt = null;	// 재활용 x 다시 선언해야 사용가능
		ResultSet rs = null;
		
		PreparedStatement pstmt = null;	// 재활용 가능
		
		public void exam_01(int num) {
			String pstmtquery ="select ename, salary, salary+? from employee";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, num);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getInt("salary")+"\t");
					System.out.println(rs.getInt("salary")+num);
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_02(int num, int bonuse) {
			String pstmtquery ="select ename, salary, salary*?+? from employee order by salary*?+? desc";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, num);
				pstmt.setInt(2, bonuse);
				pstmt.setInt(3, num);
				pstmt.setInt(4, bonuse);
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 2 번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getInt("salary")+"\t");
					System.out.println(rs.getInt("salary")*num+bonuse);
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_03(int num) {
			String pstmtquery ="select ename, salary from employee where salary > ? order by salary desc";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, num);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 3번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.println(rs.getInt("salary")+"\t");
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_04(int num) {
			String pstmtquery ="select ename, dno from employee where eno = ?";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, num);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 4 번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.println(rs.getInt("dno")+"\t");
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		public void exam_06(String date, String date2) {
			String pstmtquery ="select ename, job, hiredate from employee where hiredate between ? and ?";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setString(1, date);
				pstmt.setString(2, date2);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 6 번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					if(rs.getString("job").length() <=7){
						System.out.print(rs.getString("job")+"\t\t");
					}else {
						System.out.print(rs.getString("job")+"\t");
					}
					System.out.println(rs.getString("hiredate"));
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_07(int num, int num2) {
			String pstmtquery ="select ename, dno from employee where dno in(?,?) order by ename";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, num);
				pstmt.setInt(2, num2);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 7 번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.println(rs.getInt("dno")+"\t");
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_07(String s) {
			String pstmtquery ="select ename, dno from employee where dno in(?,?) order by ename";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setString(1, s);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 7번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.println(rs.getInt("dno")+"\t");
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void exam_08(int n1, int n2,int no, int no2) {
			String pstmtquery ="select ename, salary, dno from employee where salary between ? and ? and dno in(?,?) order by ename";
			
			try {
				conn = manager.getConnection();
				pstmt = conn.prepareStatement(pstmtquery);
				pstmt.setInt(1, n1);
				pstmt.setInt(2, n2);
				pstmt.setInt(3, no);
				pstmt.setInt(4, no2);
				
				
				rs = pstmt.executeQuery();
				System.out.println();
				System.out.println("-------- 8번 ---------");
				while(rs.next()) {
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getInt("salary")+"\t");
					System.out.println(rs.getInt("dno")+"\t");
				}
				
			}catch(Exception e) {
				System.out.println("ERROR");
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
}
