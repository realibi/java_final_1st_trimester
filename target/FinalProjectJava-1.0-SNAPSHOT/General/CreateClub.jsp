<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ServletCreateRequestClub">
<input type="text" name="TitleOfClub" placeholder="TitleOfClub"><br>
    <textarea name="DescriptionOfClub" placeholder="Description"></textarea>
    <input type="submit">
</form>
</body>
</html>
