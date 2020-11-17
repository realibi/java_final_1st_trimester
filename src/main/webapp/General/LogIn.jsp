<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>

<div class="loginBlock">
    <img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="" style="width: 70px; height: 70px; border: 1px solid transparent; border-radius: 16px;">
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/ServletLogIn">
        <p>Email:</p>
        <input type="text" id="email" name="Student_Email"> <br><br>

        <p>Password:</p>
        <input type="password" id="password" name="Student_Password"> <br><br><br>

        <input type="submit" id="loginBtn" value="Log in">
    </form>
</div>

<%@include file="/global/footer.jsp"%>