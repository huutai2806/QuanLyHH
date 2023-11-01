<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
</head>
<body>
	<h3>Product List</h3>
	<p style="color: red;">${errorString}</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Price</th>
			<th><a href="editProduct.jsp">Edit</a></th>
			<th><a href="delete.jsp">Delete</a></th>
		</tr>
		<c:forEach items="${product}" var="product">
			<tr>
				<td>${product.Id}</td>
				<td>${product.Name}</td>
				<td>${product.Type}</td>
				<td>${product.Price}</td>
				<td><a href="editproduct?code=${product.ID}">Edit</a></td>
				<td><a href="deleteproduct?code=${product.ID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="newProduct.jsp">Create Product</a>
</body>
</html>