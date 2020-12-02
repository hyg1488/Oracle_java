package View;

import java.util.List;

import Domain.EmpVo;
import Mapper.EmpDAO;

public class exam {
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getinstatnce();
		List<EmpVo> ll = dao.exam_01();
		System.out.println("에제 01 번");
		for(EmpVo a : ll) {
			System.out.print(a.getEname()+"\t");
			System.out.println(a.getJob());
		}
		
		ll = dao.exam_02();
		System.out.println("에제 02번");
		for(EmpVo a : ll) {
			System.out.print(a.getEname()+"\t");
			System.out.println(a.getJob());
		}
		
		dao.createExam_02();
	}
}
