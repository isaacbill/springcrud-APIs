<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>Subcategories</title>
    <style>
table, th, td {
  border: 1px solid black;
  padding: 5px;
}
table {
  border-spacing: 1px;
}
 </style>
</head>
<body>
    <h1>Subcategories</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category ID</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="subcategory" items="${subcategories}">
            <tr>
                <td>${subcategory.id}</td>
                <td>${subcategory.name}</td>
                <td>${subcategory.categoryId}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/subcategories/edit/${subcategory.id}"class="btn btn-primary">Edit</a>
                    <a href="${pageContext.request.contextPath}/subcategories/delete/${subcategory.id}"class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/subcategories/add"class="btn btn-success">Add Subcategory</a>
</body>
</html>