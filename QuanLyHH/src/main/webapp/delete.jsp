<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product</title>
</head>
<body>
    <h1>Delete Product</h1>
    <p>Bạn có muốn xoá product này không?</p>
    <form method="POST" action="deleteProductServlet">
        <input type="hidden" name="productId" value="${product.id}">
        <button type="submit">Có</button>
        <a href="Productlist.jsp">Không, thoát</a>
    </form>
</body>
</html>
