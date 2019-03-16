package org.student.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("进入servlet1");
		String fileName = request.getParameter("filename");
		System.out.println("进入servlet2");
		//下载文件：需要设置消息头
		response.addHeader("contentType", "application/octet-stream"); //MIME类型为二进制文件
		response.addHeader("content-Disponsition", "attachment;filename = "+fileName);
		
		//Servlet通过文件的地址，将文件转为输入流读到servlet中去
		InputStream in = getServletContext().getResourceAsStream("/res/MIME.png");
		
		//输出流将刚才已经转为输入流的文件输出给用户
		ServletOutputStream out = response.getOutputStream();
		
		byte[] bs = new byte[10];
		int len= -1;
		while((len=in.read(bs))!=-1){		
			out.write(bs,0,len);		
		}
		out.close();
		in.close();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
