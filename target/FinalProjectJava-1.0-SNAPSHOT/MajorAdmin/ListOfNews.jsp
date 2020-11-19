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

            <c:forEach var="news" items="${selectNewsByClubs}">
                <form method="post" action="<%=request.getContextPath()%>/ServletUpdateNewsForMajor">
                    <div class="student-info">
                        <div class="student-info-title">Title:</div>
                        <div class="student-info-text">
                            <input type="text" name="title" value="${news.title}">
                        </div>
                    </div>

                    <div class="student-info">
                        <div class="student-info-title">Description:</div>
                        <div class="student-info-text">
                            <input type="text" name="description" value="${news.description}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-12">
                            <button type="submit" name="update" value="${news.id}">Update</button>
                        </div>
                    </div>
                </form>
                <div class="row">
                        <div class="col-12">
                            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteNewsForMajor">
                                <td><button type="submit" name="delete" value="${news.id}">Delete</button></td>
                            </form>
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
