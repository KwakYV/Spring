<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2> Product title: ${product.title}</h2>
<h2>          Cost: ${product.cost}</h2>
<br>
<c:url var="deleteUrl" value="/product/delete">
    <c:param name="id" value="${product.id}" />
</c:url>
<a href="${deleteUrl}"> Delete </a>
<br>
<c:url var="editUrl" value="/product/edit">
    <c:param name="id" value="${product.id}" />
</c:url>
<a href="${editUrl}"> Edit </a>
</body>
</html>