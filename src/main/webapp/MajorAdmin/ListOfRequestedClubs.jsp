<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 06.11.2020
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<form method="post" action="<%=request.getContextPath()%>/ServletSelectRequestedClubsParameters">
<input type="submit">
</form>
<c:forEach var="RequestParameters" items="${Parameters}">
    <form method="post" action="<%=request.getContextPath()%>/ServletAddOrDeleteRequestedClubs">
    <input type="text" name="RequestedClubTitle" value="${RequestParameters.title}"><br>
    <input type="text" name="RequestedClubEmail" value="${RequestParameters.email}"><br>
    <input type="text" name="RequestedClubName" value="${RequestParameters.name}"><br>
    <input type="text" name="RequestedClubSurname" value="${RequestParameters.surname}"><br>
    <input type="text" name="RequestedClubDescription" value="${RequestParameters.description}"><br>
    <input type="submit" name="Action" value="Delete">
    <input type="submit" name="Action" value="Add">
    </form>
</c:forEach>
</body>
</html>
