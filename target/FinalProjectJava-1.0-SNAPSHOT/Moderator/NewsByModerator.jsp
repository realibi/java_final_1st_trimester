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


<div class="col-md-8 col-sm-9 col-xs-12">
    <form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
        <input style="width: 100%;" class="btn btn-primary"  type="submit" value="logOut">
    </form>

    <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
        <input style="width: 100%;" class="btn btn-primary"  type="submit" value="Back">
    </form>


    <div class="title-block">
        News
    </div>

    <div class="feed-block">

        <c:forEach var="news" items="${NewsByModerator}">
            <form method="post" action="<%=request.getContextPath()%>/ServletUpdateNewsByModerator">
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
                        <button style="width: 100%;" class="btn btn-primary"  type="submit" name="update" value="${news.id}">Update</button>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="col-12">
                    <form method="post" action="<%=request.getContextPath()%>/ServletDeleteNewsByModerator">
                        <button style="width: 100%;" class="btn btn-primary"  type="submit" name="delete" value="${news.id}">Delete</button>
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

        <form method="post" action="<%=request.getContextPath()%>/ServletCreateNewsByModerator">
            <p>Title:</p>
            <input type="text" name="title"><br><br>

            <p>Description:</p>
            <input type="text" name="description"><br><br>
            <button style="width: 100%;" class="btn btn-primary"  type="submit" name="create">Create</button>
        </form>
    </div>
</div>


<%@include file="/global/footer.jsp"%>