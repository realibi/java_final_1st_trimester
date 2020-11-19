<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>

<div class="loginBlock">
    <c:forEach var="list" items="${ListOfClubsByModerator}">
        <form method="post" action="<%=request.getContextPath()%>/ServletUpdateClubByModerator">
            <p>Title:</p>
            <input type="text" name="title" value="${list.title}"> <br><br>

            <p>Description:</p>
            <input type="text" name="description" value="${list.description}"> <br><br><br>

            <input type="submit" name="update" value="update">
        </form>

        <br>

        <form method="post" action="<%=request.getContextPath()%>/ServletNewsByModerator">
            <td><button type="submit" name="NEWS" value="${list.id}">NEWS</button></td>
        </form>

        <br>

        <form method="post" action="<%=request.getContextPath()%>/ServletEventsByModerator">
            <td><button type="submit" name="EVENTS" value="${list.id}">EVENTS</button></td>
        </form>
    </c:forEach>
</div>

<%@include file="/global/footer.jsp"%>