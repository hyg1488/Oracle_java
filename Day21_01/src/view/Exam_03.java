package view;

import DAO.EmpDAO;
import vo.EmpVO;

public class Exam_03 {
	public static void main(String[] args) {
		EmpDAO m = EmpDAO.getInstance();
		EmpVO vo = new EmpVO();
		int num = 2;
		String name = "LeeJH";
		String job = "soldier";
		int salary = 1150;
		int dno = 20;
		
		vo.setEno(num);
		vo.setEname(name);
		vo.setJob(job);
		vo.setSlary(salary);
		vo.setDno(dno);
		
		m.exam_03(vo);
		m.exam_04();
	}

}
