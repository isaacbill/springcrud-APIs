<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subcategories</title>
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
                    <a href="${pageContext.request.contextPath}/subcategories/edit/${subcategory.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/subcategories/delete/${subcategory.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/subcategories/add">Add Subcategory</a>
</body>
</html>