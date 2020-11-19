<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feed.css"/>

<form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
    <input type="submit" value="logOut">
</form>

<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
    <input type="submit" value="Back">
</form>

<div class="row">
    <div class="col-md-8 col-sm-9 col-xs-12">
        <div class="title-block">
            Feed
        </div>

        <div class="feed-block">

            <c:forEach var="Event" items="${ListOfEvents}">
                <div class="feed-item">
                    <div class="feed-top">
                        <div class="feed-title">${Event.title}</div>
                    </div>
                    <div class="feed-content">
                        <div class="feed-text">${Event.description}</div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<%@include file="/global/footer.jsp"%>