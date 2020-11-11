<%@ page import="java.util.ArrayList" %>
<%@ page import="FindStudent.FindStudent" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/ServletLogOut">
    <input type="submit" value="logOut">
</form>

<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
    <input type="submit" value="Back">
</form>

<table border="1">

    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="List" items="${ListOfModerators}">
        <form method="post" action="<%=request.getContextPath()%>/ServletDeleteModerator">
    <tr>
        <td>${List.name}</td>
        <td>${List.surname}</td>
        <td><input type="email" name="Email" value="${List.email}"></td>
        <th><input type="submit" name="delete" value="delete"></th>
    </tr>
        </form>
    </c:forEach>
</table>


<form method="post" action="<%=request.getContextPath()%>/ServletOutPutListOfStudents">
<input type="search" name="searchUser"><br>
<select name="SelectMajors">
    <option selected>Chose Major</option>
<c:forEach var="Major" items="${selectAllMajors}">
    <option value="${Major.student_Major}">${Major.student_Major}</option>
</c:forEach>
</select><br>
<select name="SelectGroups">
    <option selected>Chose Group</option>
<c:forEach var="Groups" items="${selectAllGroups}"><
        <option value="${Groups.student_Group}">${Groups.student_Group}</option>
</c:forEach>
</select><br>
<select name="SelectYear">
    <option selected>Chose Year</option>
<c:forEach var="Year" items="${selectAllAcademicYears}"><
        <option value="${Year.academicYear}">${Year.academicYear}</option>
</c:forEach>
</select><br>
    <input type="submit">
</form>

<c:forEach var="Info" items="${key}">
<form method="post" action="<%=request.getContextPath()%>/ServletAddModerators">
<input type="text" value="${Info.student_Email}" name="UserEmail">
    <input type="text" value="${Info.student_Name}" name="UserName">
    <input type="text" value="${Info.student_Surname}" name="UserSurname">
    <input type="text" value="${Info.student_Major}">
    <input type="text" value="${Info.student_Group}">
    <input type="number" value="${Info.academicYear}">
    <c:if test = "${Info.student_Status == 'User'}" >
        <input type = "submit" name="Action" value = "Make this User Moderator" ><br >
    </c:if>
</form>
</c:forEach>
</body>
</html>
