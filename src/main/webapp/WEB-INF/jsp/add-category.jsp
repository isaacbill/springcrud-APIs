<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <h1>Add Category</h1>
    <form action="${pageContext.request.contextPath}/categories/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <input type="submit" value="Add Category">
    </form>
</body>
</html>