package view;

import java.util.List;

import vo.*;
import dao.*;

public class Exam {
	public static void main(String[] args) {
		EmpDAO DAO = EmpDAO.getInstatnce();
		
		List <EmpVO> list = DAO.Test();
		System.out.println("년도\t 달");
		for (EmpVO emp : list) {
			System.out.println(emp.getYear() +"\t" +emp.getMonth());
		}
		
		System.out.println("문제 1번");
		list = DAO.Exam_01();
		System.out.println("년도\t 달");
		for (EmpVO emp : list) {
			System.out.println(emp.getYear() +"\t" +emp.getMonth());
		}
		
		System.out.println();
		System.out.println("문제 2번");
		list = DAO.Exam_02("04");
		System.out.println("ENO\tENAME\tJOB\tMANAGER\t\tHIREDATE\tSALARY");
		for (EmpVO emp : list) {
			System.out.print(emp.getEno() +"\t" +emp.getEname()+"\t"+emp.getJob()+"\t");
			System.out.println(emp.getManager() +"\t\t" +emp.getHireday()+"\t"+emp.getSalary());
		}
		
		System.out.println();
		System.out.println("문제 3번");
		list = DAO.Exam_03("짝");
		System.out.println("ENO\tENAME\tJOB\t\tMANAGER\t\tHIREDATE\tSALARY");
		for (EmpVO emp : list) {
			System.out.print(emp.getEno() +"\t" +emp.getEname()+"\t");
			if(emp.getJob().length() <=7) {
				System.out.print(emp.getJob()+"\t\t");
			}else {
				System.out.print(emp.getJob()+"\t");
			}
			System.out.println(emp.getManager() +"\t\t" +emp.getHireday()+"\t"+emp.getSalary());
		}
		
		System.out.println();
		System.out.println("문제 4번");
		list = DAO.Exam_04();
		System.out.println("HIREDATE\t\tTO_CHAR");
		for (EmpVO emp : list) {
			System.out.print(emp.getHireday()+"\t");
			System.out.println(emp.getAnswer());
		}
	}
}
