<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Subcategory</title>
</head>
<body>
    <h1>Add Subcategory</h1>
    <form action="${pageContext.request.contextPath}/subcategories/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="categoryId">Category ID:</label>
        <input type="text" id="categoryId" name="categoryId"><br>
        <input type="submit" value="Add Subcategory">
    </form>
</body>
</html>