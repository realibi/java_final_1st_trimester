<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ServletLogIn">
    <label>
        <input type="Email" name="Student_Email">
    </label>
    <label>
        <input type="password" name="Student_Password">
    </label>
    <input type="submit">
</form>
</body>
</html>
