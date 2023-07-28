<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>Add Category</title>
</head>
<body>
    <h1>Add Category</h1>
    <form action="${pageContext.request.contextPath}/categories/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <input type="submit" class="btn btn-success"value="Add Category">
    </form>
</body>
</html>