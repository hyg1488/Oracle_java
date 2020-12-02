package Exam;

import sql.EmpSQL;

public class Exam_01 {
	public static void main(String[] args) {
//		EmpSQL sql = new EmpSQL();
//		sql.exam_01(1800);
//		sql.exam_01("SCOTT");
//		sql.exam_01(10,"manager");
//		sql.exam_02("M");
//		sql.exam_02(1500, "manager", 10);
//		
		EmpExam ee = new EmpExam();
		ee.exam_01(300);
		ee.exam_02(12, 100);
		ee.exam_03(2000);
		ee.exam_04(7788);
		ee.exam_06("81/02/20","81/05/01");
		ee.exam_07(20,30);
		ee.exam_08(2000,3000,20,30);
		
	}
}
