package oracle.vo;

import java.util.Date;

public class EmpVo {
	private int eno;
	private String ename;
	private String job;
	private String dname;
	private int manager;
	private int slary;
	private int slary_add;
	private Date hireDate;
	
	
	
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSlary_add() {
		return slary_add;
	}

	public void setSlary_add(int slary_add) {
		this.slary_add = slary_add;
	}

	private int dno;
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getSlary() {
		return slary;
	}

	public void setSlary(int slary) {
		this.slary = slary;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getEno() {
		return eno;
	}
	
	public void setEno(int eno) {
		this.eno = eno;
	}
	
}
