<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feed.css"/>

<style>
    .student-info-title{
        float: left;
    }
    .student-info-text{
        text-align: right;
    }
</style>

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

            <c:forEach var="events" items="${eventsByModerators}">
                <form method="post" action="<%=request.getContextPath()%>/ServletUpdateEventsByModerator">
                    <div class="student-info">
                        <div class="student-info-title">Title:</div>
                        <div class="student-info-text">
                            <input type="text" name="title" value="${events.title}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Description:</div>
                        <div class="student-info-text">
                            <input type="text" name="description" value="${events.description}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-12">
                            <button type="submit" name="update" value="${events.id}">Update</button>
                        </div>
                    </div>
                </form>
                    <div class="row">
                        <div class="col-12">
                            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteEventsByModerator">
                                <td><button type="submit" name="delete" value="${events.id}">Delete</button></td>
                            </form>
                        </div>
                    </div>
                <hr>
                <br>
            </c:forEach>

        </div>
    </div>
    <div class="col-md-4 col-sm-12 col-xs-12">
        <div class="nav-bar">
            <div class="title-block-nb">
                Write something!
            </div>
            <br>

            <form method="post" action="<%=request.getContextPath()%>/ServletCreateEventsByModerator">
                <p>Title:</p>
                <input type="text" name="title"><br><br>

                <p>Description:</p>
                <input type="text" name="description"><br><br>
                <input type="submit" name="create" value="create">
            </form>
        </div>
    </div>
</div>

<%@include file="/global/footer.jsp"%>