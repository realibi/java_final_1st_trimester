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

<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsForMajor">
    <input type="submit" value="Back">
</form>

<div class="row">
    <div class="col-md-8 col-sm-9 col-xs-12">
        <div class="title-block">
            Feed
        </div>

        <div class="feed-block">

            <c:forEach var="RequestParameters" items="${Parameters}">
                <form method="post" action="<%=request.getContextPath()%>/ServletAddOrDeleteRequestedClubs">

                    <div class="student-info">
                        <div class="student-info-title">Title:</div>
                        <div class="student-info-text">
                            <input type="text" name="RequestedClubTitle" value="${RequestParameters.title}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Email:</div>
                        <div class="student-info-text">
                            <input type="text" name="RequestedClubEmail" value="${RequestParameters.email}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Name:</div>
                        <div class="student-info-text">
                            <input type="text" name="RequestedClubName" value="${RequestParameters.name}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Surname:</div>
                        <div class="student-info-text">
                            <input type="text" name="RequestedClubSurname" value="${RequestParameters.surname}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Description:</div>
                        <div class="student-info-text">
                            <input type="text" name="RequestedClubDescription" value="${RequestParameters.description}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-6">
                            <input type="submit" name="Action" value="Add">
                        </div>
                        <div class="col-6">
                            <input type="submit" name="Action" value="Delete">
                        </div>
                    </div>
                </form>
                <hr>
                <br>
            </c:forEach>

        </div>
    </div>
</div>

<%@include file="/global/footer.jsp"%>
