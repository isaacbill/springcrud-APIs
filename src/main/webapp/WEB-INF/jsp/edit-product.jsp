<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>Edit Product</title>
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
    <h1>Edit Product</h1>
    <form action="${pageContext.request.contextPath}/products/edit/${product.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${product.name}"><br>
        <label for="categoryId">Category:</label>
        <select id="categoryId" name="categoryId">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}" ${category.id == product.categoryId ? 'selected' : ''}>${category.name}</option>
            </c:forEach>
        </select><br>
        <label for="subcategoryId">Subcategory:</label>
        <select id="subcategoryId" name="subcategoryId">
            <c:forEach var="subcategory" items="${subcategories}">
                <option value="${subcategory.id}" ${subcategory.id == product.subcategoryId ? 'selected' : ''}>${subcategory.name}</option>
            </c:forEach>
        </select><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${product.description}"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}"><br>
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" value="${product.quantity}"><br>
        <input type="submit" class="btn btn-primary"value="Update Product">
    </form>
</body>
</html>