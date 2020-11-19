<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 11.11.2020
  Time: 20:49
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



<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Email</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Update</th>
        <th>Delete</th>
        <th>News</th>
        <th>Events</th>
    </tr>

    <c:forEach var="Clubs" items="${AllClubs}">
        <tr>
            <form method="post" action="<%=request.getContextPath()%>/ServletUpdateClub">
            <td><input type="text" name="title" value="${Clubs.title}"></td>
            <td><input type="text" name="description" value="${Clubs.description}"></td>
            <td>${Clubs.email}</td>
            <td>${Clubs.name}</td>
            <td>${Clubs.surname}</td>
                <td><button type="submit" name="Update" value="${Clubs.id}">Update</button></td>
            </form>
            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteClubForMajor">
                <td><button type="submit" name="Delete" value="${Clubs.id}">Delete</button></td>
            </form>
            <form method="post" action="<%=request.getContextPath()%>/ServletSelectNewsForMajor">
                <td><button type="submit" name="NEWS" value="${Clubs.id}">NEWS</button></td>
            </form>
            <form method="post" action="<%=request.getContextPath()%>/ServletEventsForMajor">
                <td><button type="submit" name="EVENTS" value="${Clubs.id}">EVENTS</button></td>
            </form>
        </tr><br>
        </form>
    </c:forEach>
</table>

<form method="post" action="<%=request.getContextPath()%>/ServletSelectRequestedClubsParameters">
<input type="submit" value="Requested Clubs">
</form>
</body>
</html>
