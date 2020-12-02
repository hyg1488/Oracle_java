package JDBCTest;


import java.sql.Connection;
import java.sql.DriverManager;

public abstract class OracleConn {
	private String myDriver = "oracle.jdbc.driver.OracleDriver";
	private String myURL ="jdbc:oracle:thin:@localhost:1521:xe";
	private String myId = "jslhrd46";
	private String myPw = "1234";
	
	protected Connection myConn;
	public OracleConn() {
		
	}
	public void makeConn() throws Exception  {
		Class.forName(myDriver);
		myConn = DriverManager.getConnection(myURL,myId,myPw);
	}
	
	public abstract void cleanUp() throws Exception;
	
	public void takeDown() throws Exception{
		cleanUp();
		myConn.close();
	}
}