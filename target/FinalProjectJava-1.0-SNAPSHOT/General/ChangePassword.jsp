<%@include file="/global/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css"/>

<form method="post" action="<%=request.getContextPath()%>/ServletListOfClubs">
    <input type="submit" value="back">
</form>

<div class="loginBlock">
    <img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="" style="width: 70px; height: 70px; border: 1px solid transparent; border-radius: 16px;">
    <br><br>
    <p>Old password:</p>
    <input type="password" id="OldPassword"> <br><br>

    <p>New password:</p>
    <input type="password" id="NewPassword"> <br><br>

    <p>Repeat password:</p>
    <input type="password" id="RepeatedPassword"><br><br><br>

    <input onclick="changeBtnPressed()" type="submit" id="loginBtn" value="Change">
</div>

<script>
    function changeBtnPressed(){
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/ServletChangePassword",
            async: true,
            data: {
                "OldPassword": $("#OldPassword").val(),
                "NewPassword": $("#NewPassword").val(),
                "RepeatedPassword": $("#RepeatedPassword").val(),
            },
            success: function(result){
                $("#OldPassword").val("");
                $("#NewPassword").val("");
                $("#RepeatedPassword").val("");
            }
        });
    }
</script>

<%@include file="/global/footer.jsp"%>
