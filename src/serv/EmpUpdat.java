package serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BAL.EmpBAL;
import Beans.EmployeeBean;

/**
 * Servlet implementation class EmpUpdate
 */
@WebServlet("/EmpUpdat")
public class EmpUpdat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("updateEmp");
		if (id!=null) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			EmployeeBean employeeBean=new EmployeeBean(Integer.valueOf(id), name, email, phone,null);
			boolean isUpdated=EmpBAL.update(employeeBean);
			if (isUpdated) {
				response.getWriter().println("<script>alert('Record Updated')</script>");
				request.getRequestDispatcher("Employees.jsp").include(request, response);
			}
		}
	}

}
