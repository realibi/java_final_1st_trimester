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
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="logOut">
    </form>

    <form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
        <input style="width: 100%;" class="btn btn-primary" type="submit" value="back">
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
        Moderators
    </div>

    <div class="feed-block">

        <c:forEach var="Info" items="${key}">
            <form method="post" action="<%=request.getContextPath()%>/ServletAddModerators">
                <div class="student-info">
                    <div class="student-info-title">Email:</div>
                    <div class="student-info-text">
                        <input type="text" value="${Info.student_Email}" name="UserEmail" readonly>
                    </div>
                </div>


                <div class="student-info">
                    <div class="student-info-title">Name:</div>
                    <div class="student-info-text">
                        <input type="text" value="${Info.student_Name}" name="UserName" readonly>
                    </div>
                </div>


                <div class="student-info">
                    <div class="student-info-title">Surname:</div>
                    <div class="student-info-text">
                        <input type="text" value="${Info.student_Surname}" name="UserSurname" readonly>
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Major:</div>
                    <div class="student-info-text">
                        <input type="text" value="${Info.student_Major}" readonly>
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Group:</div>
                    <div class="student-info-text">
                        <input type="text" value="${Info.student_Group}" readonly>
                    </div>
                </div>

                <div class="student-info">
                    <div class="student-info-title">Academic year:</div>
                    <div class="student-info-text">
                        <input type="number" value="${Info.academicYear}" readonly>
                    </div>
                </div>

                <c:if test = "${Info.student_Status == 'User'}" >
                    <input class="btn btn-primary" type = "submit" name="Action" value = "Make this User Moderator" ><br><br>
                </c:if>
            </form>

            <hr>
            <br>
        </c:forEach>

    </div>
</div>
<div class="col-md-4">
        <div class="nav-bar">
            <div class="title-block-nb">
                Find moderator!
            </div>
            <br>
            <div class="post-type">
                <form method="post" action="<%=request.getContextPath()%>/ServletOutPutListOfStudents">
                    <input type="search" name="searchUser"><br><br>
                    <select name="SelectMajors">
                        <option selected>Chose Major</option>
                        <c:forEach var="Major" items="${selectAllMajors}">
                            <option value="${Major.student_Major}">${Major.student_Major}</option>
                        </c:forEach>
                    </select><br><br>
                    <select name="SelectGroups">
                        <option selected>Chose Group</option>
                        <c:forEach var="Groups" items="${selectAllGroups}"><
                            <option value="${Groups.student_Group}">${Groups.student_Group}</option>
                        </c:forEach>
                    </select><br><br>
                    <select name="SelectYear">
                        <option selected>Chose Year</option>
                        <c:forEach var="Year" items="${selectAllAcademicYears}"><
                            <option value="${Year.academicYear}">${Year.academicYear}</option>
                        </c:forEach>
                    </select><br><br>
                    <input style="color:#fff;" class="btn btn-primary" type="submit" value="Find">
                </form>
            </div>
        </div>
    <br>
    <div class="nav-bar">
        <div class="title-block-nb">
            Your club moderators:
        </div>
        <br>
        <c:forEach var="List" items="${ListOfModerators}">
            <form method="post" action="<%=request.getContextPath()%>/ServletDeleteModerator">
                <p>${List.name}</p>
                <p>${List.surname}</p>
                <input type="email" name="Email" value="${List.email}" readonly><br><br>
                <input style="color:#fff;" class="btn btn-primary" type="submit" name="delete" value="delete">
            </form>
            <br>
            <hr>
            <br>
        </c:forEach>
    </div>
</div>

<%@include file="/global/footer.jsp"%>
