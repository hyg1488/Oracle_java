package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DBUtil.DBUtil;
import vo.EmpVO;

public class EmpDAO {
	private EmpDAO() {}
	private static EmpDAO instance = new EmpDAO();
	public static EmpDAO getInstance() {
		return instance;
	}
	
	
	public void exam_04() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "create table emp_copy as select * from employee";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void exam_03(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into emp_insert(eno, ename, "
				+ "job, hiredate, salary, dno) "
				+ "values(?,?,?, sysdate, ?,?) ";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getSlary());
			pstmt.setInt(5, vo.getDno());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public int exam_02_01(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into emp_insert(eno, ename, "
				+ "job, manager, hiredate) "
				+ "values(?,?,?,?, sysdate) ";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getManager());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	
	public int exam_02(int bno, String name, String job, int manager) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into emp_insert(eno, ename, "
				+ "job, manager, hiredate) "
				+ "values(?,?,?,?, sysdate) ";
		int row = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			pstmt.setString(2, name);
			pstmt.setString(3, job);
			pstmt.setInt(4, manager);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	public void exam_01() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "create table emp_insert as select * from employee where 1 = 0";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
