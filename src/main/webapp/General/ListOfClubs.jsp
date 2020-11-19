<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feed.css"/>

    <div class="col-md-8">
        <form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
            <input class="btn btn-primary" type="submit" value="logOut">
        </form>

        <a href="General/ChangePassword.jsp">Change Password</a>
        <c:if test="${Status.equals('Admin')}">
            <form method="post" action="<%=request.getContextPath()%>/ServletFindStudent">
                <input style="width: 100%;" class="btn btn-primary" type="submit" value="Add Moderator">
            </form>
        </c:if>
        <c:if test="${Status == 'Admin'}">
            <form method="post" action="<%=request.getContextPath()%>/ServletClubsByAdmin">
                <input style="width: 100%;" class="btn btn-primary" type="submit" value="My Club">
            </form>
        </c:if>
        <c:if test="${Status == 'Moderator'}">
            <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubsByModerator">
                <input style="width: 100%;" class="btn btn-primary" type="submit" value="My Club">
            </form>
        </c:if>


        <div class="title-block">
            Clubs
        </div>

        <div class="feed-block">

        <c:forEach var="Clubs" items="${Clubs}">
            <div class="feed-item">
                <div class="feed-top">
                    <div class="feed-title">${Clubs.title}</div>
               </div>
                <div class="feed-content">
                    <div class="feed-text">${Clubs.description}</div>
                </div>
                <div class="feed-author-date">
                    <div class="feed-author">${Clubs.email}</div>
                    <div class="feed-date">${Clubs.name} ${Clubs.surname}</div>
                </div>
                <br>
                <div class="club-buttons">
                    <div class="row">
                        <div class="col-6">
                            <form action="<%=request.getContextPath()%>/ServletListOfNews" method="post">
                                <button style="width: 100%" class="btn btn-primary" type="submit" name="NEWS" value="${Clubs.id}">News</button>
                            </form>
                        </div>
                        <div class="col-6">
                            <form action="<%=request.getContextPath()%>/ServletListOfEvents" method="post">
                                <button style="width: 100%" class="btn btn-primary" type="submit" name="EVENTS" value="${Clubs.id}">Events</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

        </div>
    </div>
    <div class="col-md-4">
        <c:set var = "Status" value = "${Status}"/>
        <c:if test="${Status == 'User'}">
            <div class="nav-bar">
                <div class="title-block-nb">
                    Create your own club!
                </div>
                <br>
                <div class="post-type">
                    <textarea rows="2" name="TitleOfClub" id="new-post-title" placeholder="Title"></textarea><br><br>
                    <textarea rows="5" name="DescriptionOfClub" id="new-post-text" placeholder="Description"></textarea><br><br>
                    <button class="btn btn-primary" onclick="createBtnPressed()">Create a club</button>
                </div>
            </div>
        </c:if>
    </div>
</div>

<script>
    function createBtnPressed(){
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/ServletCreateRequestClub",
            async: true,
            data: {
                "TitleOfClub": $("#new-post-title").val(),
                "DescriptionOfClub": $("#new-post-text").val(),
            },
            success: function(result){
                $(".nav-bar").remove();
            }
        });
    }
</script>

<%@include file="/global/footer.jsp"%>