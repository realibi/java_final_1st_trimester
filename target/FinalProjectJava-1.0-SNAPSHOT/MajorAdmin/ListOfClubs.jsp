<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/global/header.jsp"%>
    <div class="col-12">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feed.css"/>

        <form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
            <input style="width: 100%;" class="btn btn-primary" type="submit" value="logOut">
        </form>

        <form method="post" action="<%=request.getContextPath()%>/ServletSelectRequestedClubsParameters">
            <input style="width: 100%;" class="btn btn-primary" type="submit" value="Requested Clubs">
        </form>

        <div class="title-block">
            Clubs
        </div>

        <div class="feed-block">

            <c:forEach var="Clubs" items="${AllClubs}">

                    <div class="feed-item">
                        <form method="post" action="<%=request.getContextPath()%>/ServletUpdateClub">
                            <div class="feed-top">
                                <div class="feed-title">
                                    <p>Title:</p>
                                    <input type="text" name="title" value="${Clubs.title}">
                                </div>
                            </div>
                            <div class="feed-content">
                                <p>Description:</p>
                                <input type="text" name="description" value="${Clubs.description}">
                            </div>
                            <div class="feed-author-date">
                                <div class="feed-author">${Clubs.email}</div>
                                <div class="feed-date">${Clubs.name} ${Clubs.surname}</div>
                            </div>
                            <br>
                            <div class="club-buttons">
                                <div class="row">
                                    <div class="col-12">
                                        <button style="width: 100%;" class="btn btn-primary" type="submit" name="Update" value="${Clubs.id}">Update</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <div class="club-buttons">
                            <div class="row">
                                <div class="col-12">
                                    <form method="post" action="<%=request.getContextPath()%>/ServletDeleteClubForMajor">
                                        <button style="width: 100%;" class="btn btn-primary" type="submit" name="Delete" value="${Clubs.id}">Delete</button>
                                    </form>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <form method="post" action="<%=request.getContextPath()%>/ServletSelectNewsForMajor">
                                        <button style="width: 100%;" class="btn btn-primary" type="submit" name="NEWS" value="${Clubs.id}">NEWS</button>
                                    </form>
                                </div>
                                <div class="col-6">
                                    <form method="post" action="<%=request.getContextPath()%>/ServletEventsForMajor">
                                        <button style="width: 100%;" class="btn btn-primary" type="submit" name="EVENTS" value="${Clubs.id}">EVENTS</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

            </c:forEach>

        </div>
    </div>
</div>

<%@include file="/global/footer.jsp"%>