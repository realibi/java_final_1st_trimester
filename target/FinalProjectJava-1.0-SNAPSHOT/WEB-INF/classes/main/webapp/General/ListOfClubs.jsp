<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 10.11.2020
  Time: 17:34
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

<c:set var = "Status" value = "${Status}"/>
<c:if test="${Status == 'User'}">
<table border="1">

    <tr>

        <th>Title Of Club</th>
        <th>Description of Club</th>
        <th>Create</th>

    </tr>

    <tr>
        <form method="post" action="<%=request.getContextPath()%>/ServletCreateRequestClub">
        <td>
            <input type="text" name="TitleOfClub" placeholder="TitleOfClub"><br>
        </td>
        <td>
            <textarea name="DescriptionOfClub" placeholder="Description"></textarea>
        </td>
        <td>
            <input type="submit">
        </td>
        </form>
    </tr>

</table><br>
</c:if>


<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Email</th>
        <th>Name</th>
        <th>Surname</th>
        <th>News</th>
        <th>Events</th>
    </tr>

    <c:forEach var="Clubs" items="${Clubs}">
    <tr>
    <td>${Clubs.title}</td>
    <td>${Clubs.description}</td>
    <td>${Clubs.email}</td>
    <td>${Clubs.name}</td>
    <td>${Clubs.surname}</td>
        <form method="post" action="<%=request.getContextPath()%>/ServletListOfNews">
    <td><button type="submit" name="NEWS" value="${Clubs.id}">NEWS</button></td>
        </form>
        <form method="post" action="<%=request.getContextPath()%>/ServletListOfEvents">
    <td><button type="submit" name="EVENTS" value="${Clubs.id}">EVENTS</button></td>
        </form>
    </tr><br>
    </form>
</c:forEach>
</table>
<a href="General/ChangePassword.jsp">Change Password</a>
<c:if test="${Status.equals('Admin')}">
    <form method="post" action="<%=request.getContextPath()%>/ServletFindStudent">
    <input type="submit" value="Add Moderator">
    </form>
</c:if>
<c:if test="${Status == 'Admin'}">
    <form method="post" action="<%=request.getContextPath()%>/ServletClubsByAdmin">
        <input type="submit" value="My Club">
    </form>
</c:if>
<c:if test="${Status == 'Moderator'}">
    <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsByModerator">
        <input type="submit" value="My Club">
    </form>
</c:if>
</body>
</html>
