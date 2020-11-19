<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 11.11.2020
  Time: 16:03
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
        <th>Email</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Update</th>
        <th>News</th>
        <th>Events</th>
    </tr>

    <c:forEach var="list" items="${ListOfClubsByModerator}">
    <tr>
        <form method="post" action="<%=request.getContextPath()%>/ServletUpdateClubByModerator">
        <td><input type="text" name="title" value="${list.title}"></td>
        <td><input type="text" name="description" value="${list.description}"></td>
        <td>${list.email}</td>
        <td>${list.name}</td>
        <td>${list.surname}</td>
            <td><input type="submit" name="update" value="Update"></td>
        </form>
        <form method="post" action="<%=request.getContextPath()%>/ServletNewsByModerator">
            <td><button type="submit" name="NEWS" value="${list.id}">NEWS</button></td>
        </form>
        <form method="post" action="<%=request.getContextPath()%>/ServletEventsByModerator">
            <td><button type="submit" name="EVENTS" value="${list.id}">EVENTS</button></td>
        </form>
    </tr><br>

    </c:forEach>
</body>
</html>
