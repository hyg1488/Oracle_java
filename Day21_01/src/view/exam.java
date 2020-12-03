package view;

import DAO.EmpDAO;
import vo.EmpVO;

public class exam {
	public static void main(String[] args) {
		EmpDAO manager = EmpDAO.getInstance();
//		manager.exam_01();
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("데이터 업데이트");
//		int num = 1;
//	
//		String name = "leejm";
//	
//		String job = "student";
//		
//		int mana = 7077;
//		System.out.println();
//		
//		manager.exam_02(num, name, job, mana);
		int num = 1;
		String name = "jer";
		String job = "student";
		int mana = 7780;
		
		EmpVO vo = new EmpVO();
		vo.setEno(num);
		vo.setEname(name);
		vo.setJob(job);
		vo.setManager(mana);
		
		int row = manager.exam_02_01(vo);
		
	}

}
