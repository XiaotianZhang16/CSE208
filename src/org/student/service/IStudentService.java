package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	
	public boolean queryByNameAndPassword(Student student);
	
	
	//根据学号查询学生
	public Student queryBySno(Student student);
	
	public Student queryStudentBySno(int sno);

	//查询全部学生
	public List<Student> queryAllStudents();
	
	//根据学号更新学生信息
	public boolean updateStudentBySno(int sno, Student student);
	
	//根据学号删除学生
	public boolean deleteStudentBySno(int sno);
	
	//新增加学生信息
	public boolean addStudent(Student student);
	
}
