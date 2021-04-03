<%@page import="com.project.model.Subject"%>
<%@page import="java.util.Set"%>
<%@page import="com.project.model.Student"%>
<%@page import="com.project.model.Class"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.tg  {border-collapse:collapse;border-color:#aaa;border-spacing:0;margin-left: auto;margin-right: auto;}
	.tg td{background-color:#fff;border-color:#aaa;border-style:solid;border-width:1px;color:#333;
	  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg th{background-color:#ADD8E6;border-color:#aaa;border-style:solid;border-width:1px;color:black;
	  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;min-width: 250px;}
	.tg .tg-general{text-align:center;vertical-align:top}
	.previous {border: 1px solid #000; margin: 10px; background-color: #8fbc8f;color: #003300;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Class Report</title>
</head>
	<div style="text-align: left">
		<% Class item = (Class) request.getAttribute("class");%>
		<% Set<Subject> subjects = item.getSubjects();
			request.setAttribute("subjects", subjects);%>
		<% Set<Student> students = item.getStudents();
			request.setAttribute("students", students);%>
		<h1> <%=item.getName()%></h1>
		<hr style="clear:both;"/>
		
		<h2>Subjects and Teachers</h2>
		<table class="tg">
		<thead>
		  <tr>
		    <th class=tg-general>Subject</th>
		    <th class="tg-general">Teacher</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${subjects}" var="subject">
			  	<tr>
					<td class="tg-general">${subject.name}</td>
				    <td class="tg-general">${subject.teacher.firstName} ${subject.teacher.lastName}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<h2>Students Enrolled</h2>
		<table class="tg">
		<thead>
		  <tr>
		    <th class=tg-general>First Name</th>
		    <th class="tg-general">Last Name</th>
		    <th class="tg-general">Email</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
			  	<tr>
					<td class="tg-general">${student.firstName}</td>
				    <td class="tg-general">${student.lastName}</td>
				    <td class="tg-general">${student.email}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table><br>
		<a href="classReportMenu.jsp" class="previous">&laquo; Back to Class Report Menu</a>
	</div>
</body>
</html>