<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>Edit Category</title>
    <style>
         {
            width: 30%;
            padding: 5px 5px;
            margin: 5px 0;
            box-sizing: border-box;
         }
      </style>
</head>
<body>
    <h1>Edit Category</h1>
    <form action="${pageContext.request.contextPath}/categories/edit/${category.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${category.name}"><br>
        <input type="submit" class="btn btn-primary"value="Update Category">
    </form>
</body>
</html>