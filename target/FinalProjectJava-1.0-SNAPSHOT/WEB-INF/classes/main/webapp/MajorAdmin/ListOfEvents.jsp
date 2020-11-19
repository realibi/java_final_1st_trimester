<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 11.11.2020
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
    <input type="submit" value="Log out">
</form>
<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsForMajor">
    <input type="submit" value="back">
</form>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>


     <c:forEach var="events" items="${EventForMajor}">
        <tr>
            <form method="post" action="<%=request.getContextPath()%>/ServletUpdateEventForMajor">
                <td><input type="text" name="title" value="${events.title}"></td>
                <td><input type="text" name="description" value="${events.description}"></td>
                <td><button type="submit" name="update" value="${events.id}">Update</button></td>
            </form>
            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteEventsForMajor">
                <td><button type="submit" name="delete" value="${events.id}">Delete</button></td>
            </form>
        </tr><br>
    </c:forEach>

</table>
</body>
</html>
