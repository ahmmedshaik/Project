<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.dxc.JdbcService.MarkService"%>
<%@page import="com.dxc.jdbcDAO.MarkJdbcDAO"%>
<%@page import="com.dxc.jdbcDAO.ExamJdbcDAO"%>
<%@page import="com.dxc.beans.Mark"%>
<%@page import="com.dxc.beans.Exam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(
	function() {
		$("#examid").change(function(event)
		{
			var examid=$(this).children("option:selected").val();
			$.get("Getid.jsp?examid="+examid,function(result)
					{
						//alert("Result : "+$.trim(result))
						$("#marks").val($.trim(result))
					}		
					);
		});
		
	}		
	);
</script>
<meta charset="ISO-8859-1">
<title>Mark_Display</title>
</head>
<body>
 Choose one:<select id="examid" name="examid">
  <option value="examid">examid</option>
  <%
  List<Exam> exams=new ExamJdbcDAO().findAll();
  for(Exam exam:exams)
  {
  %>
    <option value="examid"><%=exam.getExamid()%></option>
    <%
  }
    %>
  </select>
  <table>
	<tr>
	<th>StudentId</th>
	<th>Name</th>
	<th>Exam_Name</th>	
	<th>Maths</th>
	<th>Physics</th>
	<th>Chemistry</th>
	</tr>
	<c:forEach var="mark" items="${marks}" >
		<tr>
		<td>${mark.getStudentid()}</td>
		<td>${mark.getName()}</td>
		<td>${mark.getExam_name()}</td>
		<td>${mark.getSub1()}</td>
		<td>${mark.getSub2()}</td>
		<td>${mark.getSub3()}</td>		
		<td><a href='markEdit.jsp?eid=${mark.getExamid()}?sid=${mark.getStudentid()}'>Edit</a>/
			<a href='deletemark?eid=${mark.getExamid()}?sid=${mark.getStudentid()}'>Delete</a></td>
		
		</tr>
	</c:forEach>
	</table>
		<br><a href="addMark.jsp">Add New Student</a><br><br>
			<a href="Modules.jsp">Go back</a><br>

</body>
</html>