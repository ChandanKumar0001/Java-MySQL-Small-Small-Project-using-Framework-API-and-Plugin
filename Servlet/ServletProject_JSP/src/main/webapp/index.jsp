<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file = "hello.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Declarative Tag -->
	<%!int a = 20;
	String name = "Samsung";
	String[] names = { "Babu", "Hani", "Ram" };%>

	<!-- Expression Tag -->
	<h2><%=a%></h2>
	<h2><%=name%></h2>

	<!-- Scriptlet Tag -->
	<%
	for (String n : names) {
	%>
	<h3><%=n%></h3>
	<%
	}
	%>
</body>
</html>