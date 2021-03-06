<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<a href="/">Homepage</a>
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
            <c:forEach var="book" items="${requestScope.books}">
                <tr>
                    <td>${book.id }</td>
                    <td>${book.title }</td>
                    <td>${book.author }</td>
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