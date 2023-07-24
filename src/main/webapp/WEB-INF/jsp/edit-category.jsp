<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
    <h1>Edit Category</h1>
    <form action="${pageContext.request.contextPath}/categories/edit/${category.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${category.name}"><br>
        <input type="submit" value="Update Category">
    </form>
</body>
</html>