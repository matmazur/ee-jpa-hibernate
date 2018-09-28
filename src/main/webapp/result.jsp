<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<a href="${pageContext.request.contextPath}">Homepage</a>
<h3>Query: <c:out value="${requestScope.query}" /></h3>

<c:choose>
    <c:when test="${not empty requestScope.books }">
        <table border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${requestScope.books}">
                <tr>
                    <td>${product.id }</td>
                    <td>${product.name }</td>
                    <td>${product.price }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <strong>Brak produktów spełniających kryteria</strong>
    </c:otherwise>
</c:choose>
</body>
</html>