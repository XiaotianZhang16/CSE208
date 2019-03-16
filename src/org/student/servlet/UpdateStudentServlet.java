package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;
public class UpdateStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取待修改人的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		//获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		//将修改后的内容封装到一个实体类中
		Student student = new Student(name,age,address);
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentBySno(no, student);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(result) {
			// out.print();
			//	response.getWriter().println("更新成功");	
			//修改完后直接跳回去显示
			response.sendRedirect("QueryAllStudentsServlet");//修改完毕后再跳回查询servlet
			}else {
				response.getWriter().println("更新失败");		
			}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
