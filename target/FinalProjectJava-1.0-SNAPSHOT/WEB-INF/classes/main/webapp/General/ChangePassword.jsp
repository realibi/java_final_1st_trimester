<%--
  Created by IntelliJ IDEA.
  User: Урал
  Date: 05.11.2020
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
    <input type="submit" value="Back">
</form>
<form method="post" action="<%=request.getContextPath()%>/ServletChangePassword">
        <input type="password" name="OldPassword" placeholder="OldPassword">

        <input type="password" name="NewPassword" placeholder="NewPassword">

        <input type="password" name="RepeatedPassword" placeholder="RepeatedPassword">

        <input type="submit">
</form>
</body>
</html>
