package JDBCTest;

public class Exam_01 {
	public static void main(String[] args) throws Exception {
		OracleSQL os = new OracleSQL();
		
		os.makeConn();
		os.exam01();
		os.takeDown();
		
		
	}
}
