package Mapper;

import java.sql.*;
import java.util.*;
import java.util.List;

import Domain.EmpVo;
import Util.DBUtil;

public class EmpDAO {
	public EmpDAO() {}
	private static EmpDAO instance = new EmpDAO();
	public static EmpDAO getinstatnce() {
		return instance;
	}
	
	public void createExam_02() {
		Connection conn = null;
		Statement stmt = null;
		String query = "create table dept_80("
				+ "dno number(2),"
				+ "dname varchar2(14),"
				+ "loc varchar2(13))";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//create 테이블 생성
	public void createExam() {
		Connection conn = null;
		// PreparedStatement pstmt = null;
		Statement stmt = null;
		// 테이블은 일회성이라 Statement 도 많이 사용함
		
		String query = "create table dept("
				+ "dno number(2),"
				+ "dname varchar2(14),"
				+ "loc varchar2(13))";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {				
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

	public List<EmpVo> exam_02(){
		List<EmpVo> ll = new ArrayList<EmpVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT ENAME, JOB\r\n" + 
				"FROM employee\r\n" + 
				"WHERE SALARY > (SELECT SALARY\r\n" + 
				"                FROM employee\r\n" + 
				"                WHERE ENO = 7499)";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				ll.add(vo);
			}
		}catch(Exception e) {
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
		
		
		return ll;
	}
	
	
	
	
	
	public List<EmpVo> exam_01(){
		List <EmpVo> ll = new ArrayList<EmpVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT ENAME, JOB\r\n" + 
				"FROM employee\r\n" + 
				"WHERE JOB =(SELECT JOB\r\n" + 
				"            FROM employee\r\n" + 
				"            WHERE ENO = 7788)";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				ll.add(vo);
			}
		}catch(Exception e) {
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
		
				
		return ll;
	}
}
