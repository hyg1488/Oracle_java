package Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.EmpVO;
import Util.DBUtil;

public class EmpDAO {
	private EmpDAO() {}
	private static EmpDAO instance = new EmpDAO();
	
	public static EmpDAO getInstance() {
		return instance;
	}
	
	
	public List<EmpVO> exam_02() {
		List <EmpVO> ee = new ArrayList <EmpVO>();
		String query = " SELECT ENAME, DNAME, LOC FROM department D JOIN employee E ON E.DNO = E.DNO";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEname(rs.getString("ename"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				
				ee.add(vo);
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
		
		return ee;
	}
	
	public EmpVO exam_01() {
		EmpVO ee = new EmpVO();
		String query = " SELECT ENAME, E.DNO, DNAME FROM employee E, DEPARTMENT D WHERE E.DNO = D.DNO AND ENAME = 'SCOTT'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ee.setEname(rs.getString("ename"));
				ee.setDno(rs.getInt("dno"));
				ee.setDname(rs.getString("dname"));
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
		
		return ee;
	}
}
