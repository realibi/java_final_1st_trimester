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

<div class="col-12">
    <form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="logOut">
    </form>

    <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsForMajor">
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="Back">
    </form>

    <div class="title-block">
        Requested clubs
    </div>

    <div class="feed-block">

        <c:forEach var="RequestParameters" items="${Parameters}">
            <form method="post" action="<%=request.getContextPath()%>/ServletAddOrDeleteRequestedClubs">

                <div class="student-info">
                    <div class="student-info-title">Title:</div>
                    <div class="student-info-text">
                        <input style="width: 50%" type="text" name="RequestedClubTitle" value="${RequestParameters.title}">
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Email:</div>
                    <div class="student-info-text">
                        <input style="width: 50%" type="text" name="RequestedClubEmail" value="${RequestParameters.email}">
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Name:</div>
                    <div class="student-info-text">
                        <input style="width: 50%" type="text" name="RequestedClubName" value="${RequestParameters.name}">
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Surname:</div>
                    <div class="student-info-text">
                        <input style="width: 50%" type="text" name="RequestedClubSurname" value="${RequestParameters.surname}">
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Description:</div>
                    <div class="student-info-text">
                        <input style="width: 50%" type="text" name="RequestedClubDescription" value="${RequestParameters.description}">
                    </div>
                </div>

                <br>

                <div class="row">
                    <div class="col-6">
                        <input style="width: 100%;" class="btn btn-primary"  type="submit" name="Action" value="Add">
                    </div>
                    <div class="col-6">
                        <input style="width: 100%;" class="btn btn-primary"  type="submit" name="Action" value="Delete">
                    </div>
                </div>
            </form>
            <hr>
            <br>
        </c:forEach>

    </div>
</div>

<%@include file="/global/footer.jsp"%>
