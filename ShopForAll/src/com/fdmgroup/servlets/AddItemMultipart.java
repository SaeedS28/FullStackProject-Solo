package com.fdmgroup.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.model.Item;

/**
 * Servlet implementation class AddItemMultipart
 */
public class AddItemMultipart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemMultipart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String name="";
		double price=0;
		int quantity=0;
		String desc="";
		String cat="";
		
		ItemDAO itd = new ItemDAO();
		System.out.println(itd.getMaxPid());
		
		String filePath=getServletContext().getRealPath("/")+"\\image";
		File file = null;

		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sup = new ServletFileUpload(factory);
			try {
				List<FileItem> params = sup.parseRequest(request);
				Iterator<FileItem> itr = params.iterator();
				
				while(itr.hasNext()) {
					FileItem item = itr.next();
					if(item.isFormField()) {
						if(item.getFieldName().equals("pName")) {
							name = item.getString();
						}
						else if(item.getFieldName().equals("pPrice")) {
							price = Double.parseDouble(item.getString());
						}
						else if(item.getFieldName().equals("pQuantity")) {
							quantity = Integer.parseInt(item.getString());
						}
						else if(item.getFieldName().equals("pDesc")) {
							desc = item.getString();
						}
						else if(item.getFieldName().equals("pCat")) {
							cat = item.getString();
						}
					}
					else {
						System.out.println("File detected");
						String fileName = item.getName();
						System.out.println(fileName);
						
						file = new File(filePath+"\\"+(itd.getMaxPid()+1)+".jpg");
						item.write(file);
						System.out.println(file.getAbsolutePath());
					}
				}
			}catch (FileUploadException e) {
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}