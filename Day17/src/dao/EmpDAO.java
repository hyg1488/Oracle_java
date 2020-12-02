package dao;

import java.sql.*;
import java.util.*;

import db.DBUtil;
import vo.EmpVO;

public class EmpDAO {
	private EmpDAO() {
		
	}
	
	private static EmpDAO instance = new EmpDAO();
	
	public static EmpDAO getInstatnce() {
		return instance;
	}
	
	
	public List<EmpVO> Exam_04() {
		List <EmpVO> ll = new ArrayList<EmpVO> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select hiredate, to_char(hiredate, 'YY/MON/DDDY') as answer from employee"; 
		
		try {
			
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate();	select 제외한 SQL
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setAnswer(rs.getDate("answer"));
				vo.setHireday(rs.getDate("hiredate"));
				
				ll.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				else if(pstmt != null) pstmt.close();
				else if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ll;
	}
	
	
	public List<EmpVO> Exam_03(String a) {
		List <EmpVO> ll = new ArrayList<EmpVO> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null; 
		
		try {
			if(a.equals("짝")) {
				sql = "select * from employee where mod(eno, 2) = 0";
			}else if(a.equals("홀")) {
				sql = "select * from employee where mod(eno, 2) != 0";
			}
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate();	select 제외한 SQL
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setEno(rs.getInt("eno"));
				vo.setManager(rs.getInt("Manager"));
				vo.setHireday(rs.getDate("hiredate"));
				vo.setSalary(rs.getInt("salary"));
				
				ll.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				else if(pstmt != null) pstmt.close();
				else if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ll;
	}
	
	
	public List<EmpVO> Exam_02(String a) {
		List <EmpVO> ll = new ArrayList<EmpVO> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employee where substr(hiredate, 4, 2) = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, a);
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate();	select 제외한 SQL
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setEno(rs.getInt("eno"));
				vo.setManager(rs.getInt("Manager"));
				vo.setHireday(rs.getDate("hiredate"));
				vo.setSalary(rs.getInt("salary"));
				
				ll.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				else if(pstmt != null) pstmt.close();
				else if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ll;
	}
	
	
	public List<EmpVO> Exam_01() {
		List <EmpVO> ll = new ArrayList<EmpVO> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select substr(hiredate, 1,2) as year, substr(hiredate,4,2) as month"
				+ " from employee";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setXXX()
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate();	select 제외한 SQL
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setMonth(rs.getString("month"));
				vo.setYear(rs.getString("year"));
				
				ll.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				else if(pstmt != null) pstmt.close();
				else if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ll;
	}
	
	public List<EmpVO> Test() {
		List<EmpVO> ll = new ArrayList<EmpVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select hiredate from employee";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setXXX()
			rs = pstmt.executeQuery();
			// pstmt.executeUpdate();	select 제외한 SQL
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setYear(rs.getString("hiredate"));
				ll.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				else if(pstmt != null) pstmt.close();
				else if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ll;
	}


	
}
