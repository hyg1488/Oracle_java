/*
 *  DDL (정의어)	CREATE , ALTER , DROP
 *  
 *  DML (조작어)	SELECT , INSERT , UPDATE , DELETE
 *  
 *  TCL (트렌잭션)	COMMIT , ROLLBACK , SAVEPOINT
 *  
 *  DCL (제어어)	GRANT , REVOKE
 *  
 *  
 *  자바 프로그래밍
 *  
 *  1. 드라이버 로딩	: Class.fornName() 
 *  2. 커넥션			: DriverManager.getConnection()
 *  3. 명령어 처리		: Statement , preparedStatement
 *  4. 쿼리			: executeQuery()
 *  
 */

import java.sql.*;

public class day14 {
	public static void main(String[] args) {
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myId = "jslhrd46";
		String myPw = "1234";
		Connection conn = null;	//기본적으로 필수 선언
		Statement stmt = null;	// 기본적으로 필수 선언
		
		ResultSet rs = null;	// select 를 쓸때 필수
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(myURL, myId, myPw);	
			
			
			stmt = conn.createStatement();	// 명령어 선언
			
			rs = stmt.executeQuery("select * from employee");
			// rs => select 를 쓰면 ResultSet 이라는 저장소에 데이터를 저장
			
			while(rs.next()) {	
			// next() 다음줄 데이터를 모두꺼내고 다음줄로 넘어가는걸 반복
				
				int eno = rs.getInt("eno");	// 테이블명 이용
				String ename = rs.getString(2); // 순서를 이용
				
				//타일에 맞는 타입으로 지정
				// 테이블명을 이용하던지, 순서를 이용해 데이터를 꺼낼수 있음.
				
				System.out.println(eno+"\t"+ename);
			}
			
			System.out.println("------");
			String query = "select DISTINCT dno , job from employee";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1) +"\t" +rs.getString(2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
