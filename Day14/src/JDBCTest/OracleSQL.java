package JDBCTest;

import java.sql.*;

public class OracleSQL extends OracleConn {
	Statement stmt = null;
	ResultSet rs = null; 
	
	public void exam01() throws Exception {
		String query = "select ename, salary, salary*12 as sum from employee";
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println("이름\t급여\t연봉");
		while(rs.next()) {
			System.out.println(rs.getString("ename")+"\t"+rs.getInt("salary")
			+"\t"+rs.getInt("sum"));
		}
	}
	
	public void exam02() throws Exception{
		
		String query = "select ename, salary, job, dno, nvl(commission, 0) as nvl, salary*12 as sum, salary*12+nvl(commission, 0) as sumNvl from employee";
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println("이름\t");
		while(rs.next()) {
			System.out.println(rs.getString("ename")+"\t"+rs.getInt("salary")+"\t\t"+rs.getString("job")
			+"\t\t"+rs.getInt("dno")+"\t"+rs.getInt("nvl")+"\t"+rs.getInt("sum")+"\t"+rs.getInt("sumNvl"));
		}
	}
	@Override
	public void cleanUp() throws Exception {
		rs.close();
		stmt.close();
	}
}
