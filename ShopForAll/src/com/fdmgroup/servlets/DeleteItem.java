package com.fdmgroup.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ItemDAO;

/**
 * Servlet implementation class DeleteItem
 */
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ApplicationContext context;
	private static Logger itemLogger = LogManager.getLogger("ItemAR");
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("delButt"));
		String filePath=getServletContext().getRealPath("/")+"\\image";
		System.out.println(filePath);
		ItemDAO itd = context.getBean(ItemDAO.class);
		File file = new File(filePath+"\\"+pid+".JPG");
		file.delete();
		
		File copy = new File("C:\\Users\\Saad\\Desktop\\FullStackProject-Solo\\ShopForAll\\WebContent\\image\\"+pid+".JPG");
		copy.delete();
		
		itemLogger.info("Item with product ID: "+ pid+", name: "+ itd.getItemByPid(pid).getName()+", and price: "+ itd.getItemByPid(pid).getPrice()
				+" deleted successfully from the store");
		
		itd.removeItem(pid);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Successfully deleted the item');");
		out.println("location='MainPage';");
		out.println("</script>");
	}

}
