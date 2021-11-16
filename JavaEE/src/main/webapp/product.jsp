<%@ page import="java.util.List"%>
<%@ page import="ru.gb.service.ProductService"%>
<%@ page import="ru.gb.entity.Product"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Bucket</title>
</head>
<body>
    <h2>Products</h2>
    <hr>
    <ul>
    <% for (Product product: (List<Product>) ((ProductService)request.getAttribute("productService")).getProducts(10)) {%>
        <li>
            Id: <%=product.getId()%>;
            Title: <%=product.getTitle()%>;
            Cost: <%=product.getCost()%>;
        </li>
    <%}%>
    </ul>

</body>
</html>