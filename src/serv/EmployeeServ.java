package serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BAL.EmpBAL;

@WebServlet("/EmployeeServ")
public class EmployeeServ extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id=request.getParameter("delete");
			if(id!=null) {
				
				boolean isDeleted=EmpBAL.delete(Integer.valueOf(id));
				if (isDeleted) {
					response.getWriter().println("<script>alert('Deleted')</script>");
				}
				response.addCookie(new Cookie("alert","Deleted"));
				response.sendRedirect("Employees.jsp");
			}
			
			id=request.getParameter("update");
			if (id!=null) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("EmpUpdate.jsp").forward(request, response);
//				boolean isUpdated=EmpBAL.update();
//				if (isUpdated) {
//					response.getWriter().println("<script>alert('Updation Successful')</script>");;
//				}
//				request.getRequestDispatcher("Employees.jsp").include(request, response);
			}
	}

}
