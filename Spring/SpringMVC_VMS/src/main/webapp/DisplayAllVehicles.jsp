<%@page import="java.util.List"%>
<%@page import="Com.jsp.spring.vms.entity.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Vehicles list</title>
</head>
<body>
	<%
	List<Vehicle> vehicles = (List) request.getAttribute("vehicleList");
	%>

	<table border="1px">
		<tr>
			<th>Vehicle Id</th>
			<th>Vehicle Brand</th>
			<th>Vehicle Model</th>
			<th>Vehicle Type</th>
			<th>Vehicle Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (Vehicle v : vehicles) {
		%>
		<tr>
			<td><%=v.getVehicleId()%></td>
			<td><%=v.getBrand()%></td>
			<td><%=v.getModel()%></td>
			<td><%=v.getType()%></td>
			<td><%=v.getPrice()%></td>
			<td><a href="find-by-id?vehicleId=<%=v.getVehicleId()%>">Update</a></td>
			<td><a href="delete-vehicle?vehicleId=<%=v.getVehicleId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>

	</table>
	<h3>
		<a href="index.jsp">Go back to Dashboard</a>
	</h3>
</body>
</html>