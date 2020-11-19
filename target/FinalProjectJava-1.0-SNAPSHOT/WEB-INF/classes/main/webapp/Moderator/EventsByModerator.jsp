<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 11.11.2020
  Time: 17:15
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

<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsByModerator">
    <input type="submit" value="Back">
</form>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Create</th>
    </tr>

    <tr>
        <form method="post" action="<%=request.getContextPath()%>/ServletCreateEventsByModerator">
            <td><input type="text" name="title"></td>
            <td><input type="text" name="description"></td>
            <td><input type="submit" name="create" value="create"></td>
        </form>
    </tr>

</table>


<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>


    <c:forEach var="events" items="${eventsByModerators}">
    <tr>
        <form method="post" action="<%=request.getContextPath()%>/ServletUpdateEventsByModerator">
            <td><input type="text" name="title" value="${events.title}"></td>
            <td><input type="text" name="description" value="${events.description}"></td>
            <td><button type="submit" name="update" value="${events.id}">Update</button></td>
        </form>
        <form method="post" action="<%=request.getContextPath()%>/ServletDeleteEventsByModerator">
            <td><button type="submit" name="delete" value="${events.id}">Delete</button></td>
        </form>
    </tr><br>
    </c:forEach>

</body>
</html>
