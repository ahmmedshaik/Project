<%@page import="com.dxc.HibService.ExamHibService"%>
<%@page import="com.dxc.JdbcService.ExamService"%>
<%@page import="com.dxc.beans.Exam"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form action="eupdate" method="post">
		<h2>
			Updating Exam Information of Id "<%=request.getParameter("id")%>"
		</h2>
		<%
			String id = request.getParameter("id");
			//Exam exam = new ExamService().find(id);
			Exam exam = new ExamHibService().find(request.getParameter("id"));
		%>
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id"
					value="<%=id%>" readonly="readonly">
				<td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=exam.getName()%>" >
				<td>
			</tr>
		</table>
		<input type="submit" value="submit"> <input type="reset"
			value="Cancel">
	</form>
</body>
</html>