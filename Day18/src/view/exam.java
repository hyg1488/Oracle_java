package view;

import Domain.EmpDTO;
import mapper.*;

public class exam {
	public static void main(String[] args) {
		EmpDAO DAO = EmpDAO.getInstance();
		
		EmpDTO emp = DAO.exam_1();
		
		System.out.println("MAX "+emp.getSalary());
		System.out.println("MAX "+emp.getSalary_add());
		System.out.println("Sum "+emp.getSum());
	}
}

