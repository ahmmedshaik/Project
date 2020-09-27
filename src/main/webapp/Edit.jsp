<%@page import="com.dxc.HibService.StudentHibServiceImp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dxc.JdbcService.StudentService"%>
<%@page import="com.dxc.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>

	<form action="update" method="post">
		<h2>
			Updating Student Information of Id "<%=request.getParameter("id")%>"
		</h2>
		<%
		//Student student = new StudentService().find(Integer.parseInt(request.getParameter("id")));
		Student student = new StudentHibServiceImp().find(Integer.parseInt(request.getParameter("id")));
		%>
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="<%=student.getStudentid()%>" readonly="readonly">
				<td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=student.getName()%>">
				<td>
			</tr>
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			%>
			<tr>
				<td>Dob</td>
				<td><input type="date" name="dob" value="<%=sdf.format(student.getDob())%>">
				<td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%=student.getEmail()%>">
				<td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value="<%=student.getMobile()%>">
				<td>
			</tr>

		</table>
		<input type="submit" value="submit"> <input type="reset"
			value="Cancel">
	</form>
</body>
</html>