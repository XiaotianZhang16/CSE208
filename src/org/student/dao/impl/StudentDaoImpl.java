package org.student.dao.impl;

import java.sql.*;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;


//数据访问层：原子性的增删改查
public class StudentDaoImpl implements IStudentDao{
	
	public boolean queryByNameAndPassword(Student student){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		try {
			Object[] obj={student.getSname(),student.getSname()};
			String  sql = "select* from student where sname = ? and spwd = ? ";
			rs = DBUtil.executeQuery(sql,obj);
			
			if(rs.next()) {return true;}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {	
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
		
		return false;
		
		
	}

	public boolean updateStudentBySno(int sno, Student student){
		String sql = "update student set sname= ?, sage=?, saddress=? where sno=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),student.getSno()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号删除学生:根据sno找到待修改的人,把这个人删除
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	
	}
	
	
	//根据姓名查询
	//根据年龄查询
	
	//判断学生是否存在
	public boolean isExist(int sno) {
		return	queryStduentBySno(sno)==null?false:true;	
	}
	
	
	//添加学生，添加之前先判断是否存在
	public boolean addStduent(Student student){
		String sql = "insert into stduent (sno,sname ,sage,saddress) values(?,?,?,?) ";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	
	//查询全部学生（很多学生）
	public List<Student> queryAllStudents(){	
		PreparedStatement pstmt = null;
		Student student = null;
		List<Student> students = new ArrayList<>();
		ResultSet rs = null;	
		try {
			String  sql = "select* from student ";
			rs = DBUtil.executeQuery(sql,null);
			while(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				students.add(student);			
			}		
			return students; 
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
			
		/*	try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();		
				if(DBUtil.connection!=null)DBUtil.connection.close();		
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		*/	
		}
		
			
			
		
		
	}

	//根据学号查学生信息
	public Student queryStduentBySno(int sno) {
		return null;
		
	}


	
	
}
