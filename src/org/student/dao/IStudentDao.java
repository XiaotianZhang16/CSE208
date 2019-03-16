package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	
		public boolean queryByNameAndPassword(Student student);
	
		public boolean updateStudentBySno(int sno, Student student);
					
		//根据学号删除学生:根据sno找到待修改的人,把这个人修改成stu
		public boolean deleteStudentBySno(int sno);
	
		//查询全部学生
		public List<Student> queryAllStudents();
		
		public boolean isExist(int sno);
		
		public boolean addStduent(Student student);
		
		//根据学号查学生信息
		public Student queryStduentBySno(int sno);


	

}
