package org.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean result = false;
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		Student student =new Student(name,pwd);
		
		IStudentService service = new StudentServiceImpl();
		result = service.queryByNameAndPassword(student);
		
		if(result) {
				request.getRequestDispatcher("welcome.jsp").forward(request, response); 
		}else{
				response.sendRedirect("fail.jsp");
		}
			
		//将此人的数据通过前台显示jsp：studentInfo.jsp
		//将此人的数据通过前台显示jsp：welcome.jsp
		
	//	request.setAttribute("student", student);
		
	//	request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
