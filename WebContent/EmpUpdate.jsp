<%@page import="Beans.EmployeeBean"%>
<%@page import="BAL.EmpBAL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		System.out.print(request.getParameter("id"));
		EmployeeBean employeeBean= EmpBAL.getEmployees(Integer.valueOf(request.getAttribute("id").toString()));
		if(employeeBean!=null){
			
	%>
	<form method="get" action="EmpUpdat">
    <div class="container">
        <div class="row border mt-5" style="border-radius:10px;background-color: gray ">
            <label class="alert alert-info"><%=request.getAttribute("id")%></label>
            <input class="form-control m-5 form-control-lg" TYPE="text" placeholder="Name" value="<%=employeeBean.getName() %>" name="name">
            <input type="text" class="form-control form-control-lg m-5" placeholder="Email" value="<%=employeeBean.getEmail() %>" name="email">
            <input type="text" placeholder="Phone" class="form-control m-5 form-control-lg" value="<%=employeeBean.getPhone() %>" name="phone">
            <button class="btn btn-block btn-success btn-lg m-5" name="updateEmp" value=<%=employeeBean.getEmpId()%>>Update</button>
        </div>
    </div>
    </form>
    <%}else{response.sendRedirect("Employees.jsp"); } %>
</body>
</html>