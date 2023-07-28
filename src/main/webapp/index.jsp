<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/bootstrap.min.css" rel="stylesheet">
    <title>CRUD Application Dashboard</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Welcome </h1>
        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">View All Products</h5>
                        <p class="card-text">Browse and manage all products in the system.</p>
                        <a href="${pageContext.request.contextPath}/products" class="btn btn-primary">Go to Products</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Manage Categories</h5>
                        <p class="card-text">Create, edit, or delete product categories.</p>
                        <a href="${pageContext.request.contextPath}/categories" class="btn btn-primary">Go to Categories</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Manage Subcategories</h5>
                        <p class="card-text">Manage subcategories for better product organization.</p>
                        <a href="${pageContext.request.contextPath}/subcategories" class="btn btn-primary">Go to Subcategories</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
