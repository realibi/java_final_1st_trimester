<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>

<div class="col-12">
    <center>
        <div class="loginBlock">
            <img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="" style="width: 70px; height: 70px; border: 1px solid transparent; border-radius: 16px;">
            <br><br>
            <form method="post" action="<%=request.getContextPath()%>/ServletLogIn">
                <p>Email:</p>
                <input style="width: 100%;" type="text" id="email" name="Student_Email"> <br><br>

                <p>Password:</p>
                <input style="width: 100%;" type="password" id="password" name="Student_Password"> <br><br><br>

                <input style="width: 100%;" class="btn btn-primary" type="submit" id="loginBtn" value="Log in">
            </form>
        </div>
    </center>
</div>

<%@include file="/global/footer.jsp"%>