package view;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmpDAO;
import db.DBUtil;

public class Test {
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		
		EmpDAO DAO = EmpDAO.getInstatnce();
		
		
		try {
		conn.close();
	
		} catch(SQLException e){
			e.printStackTrace();
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {
			
		}
		
		
	}
}
