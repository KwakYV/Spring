<%@ page import="java.util.List"%>
<%@ page import="ru.gb.entity.Cat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Cat</title>
</head>
<body>
    <h2>Cat</h2>
    <p>Name: ${cat.name}</p>
    <p>Age: ${cat.age}</p>

    <p>Kids</p>
    <hr>
    <ul>
    <% for (Cat kid: (List<Cat>) ((Cat)request.getAttribute("cat")).getChildren()) {%>
        <li> Name: <%=kid.getName()%>; Age: <%=kid.getAge() %> </li>
    <%}%>
    </ul>

</body>
</html>