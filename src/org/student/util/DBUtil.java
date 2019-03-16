package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

//通用的数据库操作方法
public class DBUtil {

	private static final String URL= "jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "13899202125zxg";	
	public static Connection connection= null;
	public static PreparedStatement pstmt=null;
	public static ResultSet rs =null;
	
	//通用的增删改	
	public static boolean executeUpdate(String sql, Object[] params){	
		try {	
			
		/*	
			pstmt = getConnection().prepareStatement(sql);
			for(int  i=0; i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);			
			}
		*/	
			pstmt = createPreparedStatement(sql, params);		
					
			int count = pstmt.executeUpdate();
			System.out.println("before "+count);
			if(count>0) {
				
				System.out.println("After "+count);
				return true;				
			}else{

				
				System.out.println("After "+count);
				return false;
			}			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
			return false;
		} catch (SQLException e) {		
			e.printStackTrace();
			return false;
		}finally {
			closeAll(null,pstmt,connection);
			
		}			
		
	}	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
	}
	
	
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);		
		if(params!=null){		
			for(int  i=0; i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
		
	}
	
	
	//通用的查，返回一个集合好，集合能表示null，一个，多个
	public static ResultSet executeQuery(String sql, Object[] params) {		
		
		Student student=null;
		List<Student> students =new ArrayList<>();		
		
		try {				
			pstmt = getConnection().prepareStatement(sql);		
			if(params!=null){		
				for(int  i=0; i<params.length;i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			System.out.println("rs =====" +rs);
			return rs;
					
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
			return null;
		} catch (SQLException e) {		
			e.printStackTrace();
			return null;
		}
			
	}
	
	public static void closeAll(ResultSet rs, Statement stmt,Connection connection) {
		
		try {
			if(rs!=null)rs.close();
			if (pstmt!=null)pstmt.close();
			if (connection!=null)connection.close();		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	
		
}
