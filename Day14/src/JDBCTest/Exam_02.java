package JDBCTest;

public class Exam_02 {
	public static void main(String[] args) throws Exception {
		OracleSQL os = new OracleSQL();
		os.makeConn();
		os.exam02();
		os.takeDown();
	}
}
