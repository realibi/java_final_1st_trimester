<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feed.css"/>


<div class="col-12">
    <form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="logOut">
    </form>

    <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="Back">
    </form>


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


<%@include file="/global/footer.jsp"%>