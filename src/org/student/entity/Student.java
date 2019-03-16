package org.student.entity;

public class Student {
	private int sno;
	private String sname;
	private String spwd;
	private int sage;
	private String saddress;
	
	public Student() {
	
	}
	
	//用用户名和密码创建实例，用于登录
	public Student(String sname, String spwd) {
		this.sname = sname;
		this.spwd= spwd;
	}
	
	public Student(int sno, String sname,String spwd) {
		this.sno = sno;
		this.sname = sname;
		this.spwd = spwd;
	}
	

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	
	
	
	
	public Student( String sname, int sage, String saddress) {
	
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	
	public Student(int sno, String sname, int sage, String saddress) {
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getSno()+this.getSname()+this.getSage()+this.getSaddress();
	}
	
}
