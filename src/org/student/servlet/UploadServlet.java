package org.student.servlet;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;


/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        response.setCharacterEncoding("utf-8");
        
        try {
        	
        boolean ismultipart = ServletFileUpload.isMultipartContent(request);
        
        //如果前台表单的enctype属性，确定是 multipart/form-data
        if(ismultipart) {
        	
    //    	FileItemFactory factory =new DiskFileItemFactory();
        	
        	DiskFileItemFactory factory = new DiskFileItemFactory();
        	
        	ServletFileUpload upload= new ServletFileUpload(factory);
        	
           
        	//通过parseRequest解析form中的所有请求字段，并保存到items集合中(即sname，sno，spicture都在items中)
        	
        	//设置上传文件时，用到的临时文件大小
			factory.setSizeThreshold(10240);
			factory.setRepository(new File ("d:\\uploadtemp"));//设置临时文件的位置
			
			//控制一下上传文件的大小
			upload.setSizeMax(20480);//单位是字节
        	
        	
        	List<FileItem> items = upload.parseRequest(request);
        	
        	//遍历items中的数据（sno sname spicture）
        	System.out.println(items);
        	
        	Iterator<FileItem> iter = items.iterator();
        	while(iter.hasNext()) {
        		
        		FileItem item = iter.next();
        		String itemName = item.getFieldName();
        		String sname=null;
        		int sno=-1;
        		System.out.println(item.isFormField());
        		
        		
        		if(item.isFormField()){
        			if(item.equals("sno")) {
            			sno = Integer.parseInt(item.getString("utf-8"));
            		}else if(itemName.equals("sname")) { 			
            			sname = item.getString("utf-8");
            		}else {
            			System.out.println("其他字段");
            		}
        			
        		}else{// spicture uploading
        			String fileName = item.getName();
        			String ext = fileName.substring(fileName.indexOf(".")+1);
        			if(!(ext.equals("png")||ext.equals("jpg")||ext.equals("gif"))){
        				System.out.println("图片类型有误，格式只能是png 等");
        				return ;
        			}
        			//限制文件上传
        		/*
        			
        			
        			if(fileName.substring(beginIndex, endIndex)) {
        				
        			}else {
        				
        			}
        		*/	
        			String path="D:\\upload";
        			File file =new File(path,fileName);
        			
        		    item.write(file);
        			System.out.println(fileName+"上传成功");
        			return ; 
        			
        			
        		}
 		
        	}
        	
        }
        
        }catch (FileUploadBase.SizeLimitExceededException e) {//下面异常的子类
        	e.printStackTrace();        	
        }catch(FileUploadException e) {
        	e.printStackTrace();       	   	
        }catch (Exception e) {
			e.printStackTrace();
		}
     }
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
