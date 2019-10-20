package serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import BAL.EmpBAL;
import Beans.EmployeeBean;
import sun.nio.ch.IOUtil;

/**
 * Servlet implementation class EmpAdd
 */
@WebServlet("/EmpAdd")
@MultipartConfig
public class EmpAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Part part=request.getPart("image");
		byte [] pic=null;
		System.out.println(part.getSubmittedFileName());
		if (part!=null) {
			pic=new byte[part.getInputStream().available()];
			part.getInputStream().read(pic);	
		}
		
		EmployeeBean employeeBean=new EmployeeBean(1,name, email, phone,pic);
		try {
			boolean isUpdated=EmpBAL.add(employeeBean);
			if (isUpdated) 
			{
				response.getWriter().println("<script>alert('Record Add')</script>");
			}
			request.getRequestDispatcher("Employees.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
