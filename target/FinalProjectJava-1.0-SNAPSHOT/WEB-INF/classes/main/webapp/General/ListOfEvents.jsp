<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 10.11.2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
    <input type="submit" value="logOut">
</form>
<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
    <input type="submit" value="Back">
</form>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
    </tr>


    <c:forEach var="Clubs" items="${ListOfEvents}">
    <tr>
        <td>${Clubs.title}</td>
        <td>${Clubs.description}</td>
    </tr><br>
    </c:forEach>
</body>
</html>
