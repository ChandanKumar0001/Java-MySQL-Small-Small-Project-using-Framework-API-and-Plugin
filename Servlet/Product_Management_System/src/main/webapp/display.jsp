<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Map<String, Object>> products = (List<Map<String, Object>>) request.getAttribute("list");

	for (Map<String, Object> product : products) {
	%>
	<p><%=product.get("productId")%></p>
	<p><%=product.get("productName")%></p>
	<p><%=product.get("productBrand")%></p>
	<p><%=product.get("productQuantity")%></p>
	<%
	}
	%>
	<br>
	<br>
	<br>

	<!-- All above Data set in the table format -->

	<table border="1px">
		<thead>
			<tr>
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Brand</td>
				<td>Product Quantity</td>
			</tr>
		</thead>

		<tbody>
			<%
			for (Map<String, Object> product : products) {
			%>
			<tr>
				<td><%=product.get("productId")%></td>
				<td><%=product.get("productName")%></td>
				<td><%=product.get("productBrand")%></td>
				<td><%=product.get("productQuantity")%></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
</body>
</html>