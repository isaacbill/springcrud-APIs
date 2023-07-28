<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>Edit Subcategory</title>
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
    <h1>Edit Subcategory</h1>
    <form action="${pageContext.request.contextPath}/subcategories/edit/${subcategory.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${subcategory.name}"><br>
        <label for="categoryId">Category ID:</label>
        <input type="text" id="categoryId" name="categoryId" value="${subcategory.categoryId}"><br>
        <input type="submit" class="btn btn-primary"value="Update Subcategory">
    </form>
</body>
</html>