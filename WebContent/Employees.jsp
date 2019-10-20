<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Base64"%>
<%@page import="Beans.EmployeeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="BAL.EmpBAL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		table{
			border-radius:20px;
		}
	</style>
</head>
<body>
    <div class="container">
        
        <div class="row">
            <div class="col-10"></div>
            <div class="col-2">
                <a href="AddEmp.html"><button class="btn btn-success">Add Employee</button></a>
            </div>

        </div>
        <div class="row table-responsive rounded">
            <div class="col-12 rounded">
                <table class="table table-striped table-danger table-bordered table-hover rounded-circle" >
                    <tr style="background-color: #985f0d;color: whitesmoke" class="rounded">
                       <th>#</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                        <th>Image</th>
                    </tr>
                    <% 
                    	int pg=1;
                    	
                    	if(request.getParameter("no")==null){
                    		pg=1;
                    	}else{
                    		pg=Integer.valueOf(request.getParameter("no"));
                    	}
                    	ArrayList<EmployeeBean> arr= EmpBAL.getEmployees();
                    	List<EmployeeBean> arrBeans=null;
                    	if(arr.size()<((pg-1)*5)+5){
                    		arrBeans=arr.subList((pg-1)*5,arr.size());
                    	}else{
                    		arrBeans=arr.subList((pg-1)*5,((pg-1)*5)+5);	
                    	}
                    	for(EmployeeBean employeeBean:arrBeans){
          	
                    %>
	                    <tr>
	                        <td><%=employeeBean.getEmpId() %></td>
	                        <td><%=employeeBean.getName() %></td>
	                        <td><%=employeeBean.getEmail() %></td>
	                        <td><%=employeeBean.getPhone() %></td>
	                        <td>
	                        	<form action="EmployeeServ" method="post">
		                            <div class="btn-group btn-group-vertical btn-block">
		                                <button class="btn btn-block btn-outline-success" value="<%=employeeBean.getEmpId()%>" name="delete">Delete</button>
		                                <button class="btn btn-block btn-outline-success" value="<%=employeeBean.getEmpId()%>" name="update">Edit</button>
		                            </div>
		                  
		                    	</form>
	                        	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Launch demo modal</button>

									<!-- Modal -->
									<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									  <div class="modal-dialog" role="document">
									    <div class="modal-content">
									      <div class="modal-header">
									        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									          <span aria-hidden="true">&times;</span>
									        </button>
									      </div>
									      <div class="modal-body">
									      	<input type="text" class="form-control mb-3" value="<%=employeeBean.getEmpId()%>">
									        <input type="text" class="form-control mb-3" value="<%=employeeBean.getName()%>">
									        <input type="text" class="form-control mb-3" value="<%=employeeBean.getPhone()%>">
									        <input type="text" class="form-control mb-3" value="<%=employeeBean.getEmail()%>">
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									        <button type="button" class="btn btn-primary">Save changes</button>
									      </div>
									    </div>
									  </div>
									</div>
	                        </td>
	                        <%if(employeeBean.getPic()!=null){ %>
	                        <td><img class="img-fluid rounded-circle w-75 mx-auto d-block" src="data:image/gif;base64,<%=new String(Base64.getEncoder().encode(employeeBean.getPic())) %>" alt="hhh.gif"></td>
	                    	<%}else{%>
	                    		<td><img alt="not found" src="hhh.gif" class="img-fluid rounded-circle w-75 mx-auto d-block"></td>
	                    	<%} %>
	                    </tr>
                    <%	
                    	}
                    %>
                </table>
                
        	</div>
        </div>
     	<div class="row">
                	<form action="Employees.jsp" method="post">
	                	<h2 class="h2">5 out of<%= arr.size()%></h2>
	                	<%
	                		for(int i=1;i<=Math.ceil(arr.size()/5)+1;i++){	
	                	%>
	                		<button type="submit" class="btn btn-outline-success ml-1" name="no" value="<%=i%>"><%=i%></button>
	                	<%}%>
                	</form>
     	</div>
    </div>
</body>
</html>