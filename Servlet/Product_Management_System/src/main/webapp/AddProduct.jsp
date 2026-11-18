<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the Product details</h1>

<%
	out.println("Inside Add Products file");
%>

<form action="add-products" method="post">
	<input type="number" placeholder="Enter ProductId" name="productId"> <br>
	<input type="text" placeholder="Enter ProductName" name="productName"> <br>
	<input type="text" placeholder="Enter ProductBrand" name="productBrand"> <br>
	<input type="number" placeholder="Enter ProductQuantity" name="productQuantity"> <br>
	<input type="submit" value="ADD">
	</form>
</body>
</html>