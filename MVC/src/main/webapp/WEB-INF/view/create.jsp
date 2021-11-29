<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Product</title>
</head>
<body>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:input path="title"/>
    <br>
    Cost: <form:input path="cost"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>