<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="${pageContext.request.contextPath}/products/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="categoryId">Category:</label>
        <select id="categoryId" name="categoryId">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select><br>
        <label for="subcategoryId">Subcategory:</label>
        <select id="subcategoryId" name="subcategoryId">
            <c:forEach var="subcategory" items="${subcategories}">
                <option value="${subcategory.id}">${subcategory.name}</option>
            </c:forEach>
        </select><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br>
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity"><br>
        <input type="submit" value="Add Product">
    </form>
</body>
</html>