<%@page import="com.dxc.JdbcService.MarkService"%>
<%@page import="java.util.List"%>
<%@page import="com.dxc.beans.Mark"%>
<%
String examid = request.getParameter("examid");
List<Mark> marks=new MarkService().find(examid);
out.print(marks);
%>