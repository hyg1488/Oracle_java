package oracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import oracle.db.DBManager;
import oracle.vo.EmpVo;
import oracle.*;

public class EmpSQL {
	
	DBManager manager = DBManager.getInstance();
	Connection conn = null;
	Statement stmt = null;	// 재활용 x 다시 선언해야 사용가능
	ResultSet rs = null;
	
	PreparedStatement pstmt = null;	// 재활용 가능
	
	public List<EmpVo> exam_11(int a){
		String query = "select ename, commisson from employee where salary = 1250";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			
//			if(a==0) {
//				query = "select ename, job from employee where manager is null";
//			}
//			else {
//				query = "select ename, job from employee where manager == "+a;
//
//			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				
				emp.setSlary(rs.getInt("commisson"));
				emp.setEname(rs.getString("ename"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	
	
	public List<EmpVo> exam_10(int a){
		String query;
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			
			
			if(a==0) {
				query = "select ename, job from employee where manager is null";
			}
			else {
				query = "select ename, job from employee where manager == "+a;

			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_09(String a){
		String query = "select ename, hiredate from employee where hiredate like ?";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setObject(1, a+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setHireDate(rs.getDate("hiredate"));
				
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_08(int a, int b, int c, int d){
		String query = "select ename, salary, dno from employee where salary between ? and ? and dno in(?,?) order by ename";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setObject(1, a);
			pstmt.setObject(2, b);
			pstmt.setObject(3, c);
			pstmt.setObject(4, d);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setSlary(rs.getInt("salary"));
				emp.setDno(rs.getInt("dno"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_07(int a, int b){
		String query = "select ename, dno from employee where dno in(?,?) order by ename";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setObject(1, a);
			pstmt.setObject(2, b);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				
				emp.setDno(rs.getInt("dno"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_06(String a, String b){
		String query = "select ename, job, hiredate from employee where hiredate between ? and ?";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setObject(1, a);
			pstmt.setObject(2, b);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHireDate(rs.getDate("hiredate"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	// a ~ b 사이에 포함되지 않는 사원 출력
	public List<EmpVo> exam_05(int a, int b){
		String query = "select ename, salary from employee where salary not between ? and ?";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			pstmt.setInt(2, b);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setSlary(rs.getInt("salary"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_04(int a){
		String query = "select ename, dno from employee where eno = ?";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setDno(rs.getInt("dno"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_03(int a){
		String query = "select ename, salary from employee where salary>? order by salary desc";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setSlary(rs.getInt("salary"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_02(int month, int bonuse){
		String query = "select ename, salary, salary*?+? as salary2 from employee order by salary2";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, month);
			pstmt.setInt(2, bonuse);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
				emp.setEname(rs.getString("ename"));
				emp.setSlary(rs.getInt("salary"));
				emp.setSlary_add(rs.getInt("salary2"));
				eList.add(emp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return eList;
		
	}
	
	public List<EmpVo> exam_01(int a) {
		String query ="select ename, salary, salary+? as salary2 from employee";
		List <EmpVo> eList = new ArrayList<EmpVo>();
		EmpVo emp = null;
		try {
			conn = manager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new EmpVo();
//				emp.setEno(rs.getInt("eno"));
				emp.setEname(rs.getString("ename"));
//				emp.setDno(rs.getInt("dno"));
//				emp.setJob(rs.getString("job"));
//				emp.setManager(rs.getInt("manager"));
				emp.setSlary(rs.getInt("salary"));
				emp.setSlary_add(rs.getInt("salary2"));
				eList.add(emp);
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
		
		return eList;
	}
}
