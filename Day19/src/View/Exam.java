package View;

import java.util.List;

import Domain.EmpVO;
import Mapper.EmpDAO;

public class Exam {
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		
		System.out.println("예제 1번");
		System.out.println("ENAME\tDNO\tDNAME");
		EmpVO vo = dao.exam_01();
		System.out.print(vo.getEname()+"\t");
		System.out.print(vo.getDno()+"\t");
		System.out.println(vo.getDname());
		System.out.println();
		
		System.out.println("예제 2번");
		System.out.println("ENAME\tDNAME\t\tLOC");
		List<EmpVO> ll = dao.exam_02();
		for(EmpVO e : ll) {
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getDname()+"\t");
			System.out.println(e.getLoc());
		}
		System.out.println();
	}
}
