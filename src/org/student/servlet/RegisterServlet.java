package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");

		Student student =new Student(id,name,pwd);	
		
		IStudentService studentService= new StudentServiceImpl();
		
		boolean result = studentService.addStudent(student);	
	
		System.out.println("=========      result : " + result); 
		//设置响应编码，在out之前设置响应编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
			
			
		PrintWriter out = response.getWriter();
		
	/* if (result) {
			out.println("增加成功！");
			response.sendRedirect("QueryAllStudentsServlet");
		}else {
			out.println("增加失败！");
		}
		*/
		if(result) { //如果增加失败，给reques放入一条数据error
			request.setAttribute("error", "addError");	
			request.getRequestDispatcher("registersucceed.jsp").forward(request, response); 
		}else {
			request.setAttribute("error", "noaddError");
			response.sendRedirect("fail.jsp");
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

