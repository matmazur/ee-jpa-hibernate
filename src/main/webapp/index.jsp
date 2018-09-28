<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Order manager</h2>

<h3>Add client</h3>
<form action="/add-client" method="post">
    <input type="text" name="firstName" placeholder="Client first name" />
    <br />
    <input type="text" name="lastName" placeholder="Client last name" />
    <br />
    <input type="text" name="address" placeholder="Address" />
    <br />
    <input type="submit" value="Add Client" />
</form>

<h3>Add order</h3>
<form action="/add-order" method="post">
    <input type="number" name="clientId" placeholder="Client ID" />
    <br />
    <input type="text" name="orderDetails" placeholder="Details" />
    <br />
    <input type="submit" value="Add Order" />
</form>

<h3>Add product</h3>
<form action="/add-product" method="post">
    <input type="text" name="productName" placeholder="Product name" />
    <br />
    <input type="text" name="productPrice" placeholder="Product price" />
    <br />
    <input type="text" name="productDetails" placeholder="Details" />
    <br />
    <input type="submit" value="Add Product" />
</form>

<h3>Add product to order</h3>
<form action="/add-product-order" method="post">
    <input type="number" name="orderId" placeholder="Order ID" />
    <br />
    <input type="number" name="productId" placeholder="Product ID" />
    <br />
    <input type="submit" value="Add Product" />
</form>

<h3>Get client</h3>
<form action="/get-client" method="get">
    <input type="number" name="clientId" placeholder="Client ID" />
    <input type="submit" value="Get Client" />
</form>

<h3>Get order</h3>
<form action="/get-order" method="get">
    <input type="number" name="orderId" placeholder="Order ID" />
    <input type="submit" value="Get Order" />
</form>

<h3>Get Product</h3>
<form action="/get-product" method="get">
    <input type="number" name="productId" placeholder="Product ID" />
    <input type="submit" value="Get Product" />
</form>


<br><br><br>

<h2>Add product</h2>
<form action="/book?add=form" method="post">
    <input type="text" name="isbn" placeholder="Isbn" />
    <input type="text" name="title"  placeholder="Title" />
    <input type="text" name="author" placeholder="Author" />
    <input type="submit" value="Add" />
</form>

<form action="/book?add=form" method="post">
    <input type="text" name="query" placeholder="JPQL Query" style="width: 500px" />
    <input type="submit" value="Get" />
</form>
</body>
</html>