<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD Application</title>
</head>
<body>
    <h1>Welcome to CRUD Application</h1>
    <ul>
        <li><a href="${pageContext.request.contextPath}/products">View All Products</a></li>
        <li><a href="/categories">Manage Categories</a></li>
        <li><a href="/subcategories">Manage Subcategories</a></li>
    </ul>
</body>
</html>