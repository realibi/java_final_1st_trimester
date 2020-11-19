<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>

<div class="loginBlock">

    <c:forEach var="list" items="${ClubsByAdmin}">
    <form method="post" action="<%=request.getContextPath()%>/ServletUpdateClubByAdmin">
        <p>Title:</p>
        <input type="text" name="title" value="${list.title}"> <br><br>

        <p>Description:</p>
        <input type="text" name="description" value="${list.description}"> <br><br><br>

        <input type="submit" name="update" value="update">
    </form>

    <br>

    <form method="post" action="<%=request.getContextPath()%>/ServletDeleteClub">
        <input type="submit" name="delete" value="delete">
    </form>

    <br>

    <form method="post" action="<%=request.getContextPath()%>/ServletNewsByClub">
        <button type="submit" name="NEWS" value="${list.id}">NEWS</button>
    </form>

    <br>

    <form method="post" action="<%=request.getContextPath()%>/ServletEventsByClub">
        <button type="submit" name="EVENTS" value="${list.id}">EVENTS</button>
    </form>
</c:forEach>
</div>

<%@include file="/global/footer.jsp"%>