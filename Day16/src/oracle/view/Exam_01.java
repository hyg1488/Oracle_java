package oracle.view;

import oracle.EmpSQL;
import oracle.vo.EmpVo;
import java.util.*;
public class Exam_01 {
	public static void main(String[] args) {
		EmpSQL sql = new EmpSQL();
		
		List <EmpVo> List = sql.exam_01(300);
		
		System.out.println("Exam 01");
		System.out.println("ENAME\tSALARY\tSALARY+300");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.print(List.get(i).getSlary_add());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 02");
		List = sql.exam_02(12, 100);
		System.out.println("ENAME\tSALARY\tSALARY*12+100");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.print(List.get(i).getSlary_add());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 03");
		List = sql.exam_03(2000);
		System.out.println("ENAME\tSALARY");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 04");
		List = sql.exam_04(7788);
		System.out.println("ENAME\tDNO");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getDno()+"\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 05");
		List = sql.exam_05(2000,3000);
		System.out.println("ENAME\tSalary");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 06");
		List = sql.exam_06("81/02/20","81/05/01");
		System.out.println("ENAME\tJOB\t\tHIREDATE");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			if(List.get(i).getJob().length() <=7 ) {
				System.out.print(List.get(i).getJob()+"\t\t");
			}
			else {
				System.out.print(List.get(i).getJob()+"\t");
			}
			System.out.print(List.get(i).getHireDate()+"\t");
			System.out.println();
		}
		

		System.out.println();
		System.out.println("Exam 07");
		List = sql.exam_07(20, 30);
		System.out.println("ENAME\tDNO");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getDno()+"\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 08");
		List = sql.exam_08(2000, 3000, 20, 30);
		System.out.println("ENAME\tSALARY\tDNO");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.print(List.get(i).getDno()+"\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 09");
		List = sql.exam_09("81");
		System.out.println("ENAME\tHIREDATE");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getHireDate());
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("Exam 10");
		List = sql.exam_10(0);
		System.out.println("ENAME\tJOB");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getEname()+"\t");
			System.out.print(List.get(i).getJob());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Exam 11");
		List = sql.exam_10(0);
		System.out.println("ENAME\tJOB");
		for (int i = 0; i < List.size(); i++) {
			System.out.print(List.get(i).getSlary()+"\t");
			System.out.print(List.get(i).getEname()+"\t");
			
			System.out.println();
		}
	}
}
