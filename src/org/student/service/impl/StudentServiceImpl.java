package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层：逻辑性的增删改查（对DAO层进行的组装）
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao= new StudentDaoImpl();
	
	
	public boolean queryByNameAndPassword(Student student) {	
		return studentDao.queryByNameAndPassword(student);		
	}
	
	
	//根据学号查询学生
	public Student queryBySno(Student student) {
		
		return studentDao.queryStduentBySno(student.getSno());
		
	}
	
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStduentBySno(sno);
		
	}
	
	
	
	
	//查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	
	public boolean updateStudentBySno(int sno, Student student){
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);		
		}else {
			System.out.println("此人不存在！");
			return false;
		}
		
	}


	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
			
		}else {
			System.out.println("此人不存在，无法删除！");
			return false;
		}
		
	}
	
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStduent(student);
			System.out.println("此人不存在，刚添加！");
			return true;
			
		}else {
			System.out.println("此人已存在，无法添加！");
			return false;
		}
		
	}

}
