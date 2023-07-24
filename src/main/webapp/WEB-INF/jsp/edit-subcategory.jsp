<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Subcategory</title>
</head>
<body>
    <h1>Edit Subcategory</h1>
    <form action="${pageContext.request.contextPath}/subcategories/edit/${subcategory.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${subcategory.name}"><br>
        <label for="categoryId">Category ID:</label>
        <input type="text" id="categoryId" name="categoryId" value="${subcategory.categoryId}"><br>
        <input type="submit" value="Update Subcategory">
    </form>
</body>
</html>