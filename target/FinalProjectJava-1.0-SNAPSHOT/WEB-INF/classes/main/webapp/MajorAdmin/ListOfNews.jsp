<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 11.11.2020
  Time: 22:31
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


    <c:forEach var="news" items="${selectNewsByClubs}">
        <tr>
            <form method="post" action="<%=request.getContextPath()%>/ServletUpdateNewsForMajor">
                <td><input type="text" name="title" value="${news.title}"></td>
                <td><input type="text" name="description" value="${news.description}"></td>
                <td><button type="submit" name="update" value="${news.id}">Update</button></td>
            </form>
            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteNewsForMajor">
                <td><button type="submit" name="delete" value="${news.id}">Delete</button></td>
            </form>
        </tr><br>
    </c:forEach>

</table>
</body>
</html>
