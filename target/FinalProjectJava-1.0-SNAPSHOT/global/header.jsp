<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AITU Portal</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
          crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-4 col-xs-12">
                <% if(request.getSession().getAttribute("userId") != null){ %>
                <div class="nav-bar">
                    <div class="logo" style="text-align: center">
                        <img src="<%=request.getContextPath()%>/resources/img/logo.png" alt="" style="width: 70px; height: 70px; border: 1px solid transparent; border-radius: 16px;">
                    </div>

                    <br>

                    <a href="<%=request.getContextPath()%>/feed">
                        <div class="nav-bar-item">
                            <div class="menu-icon">
                                <img src="<%=request.getContextPath()%>/resources/img/news.png" alt="">
                            </div>
                            <div class="menu-text">
                                Feed
                            </div>
                        </div>
                    </a>

                    <a href="<%=request.getContextPath()%>/clubs">
                        <div class="nav-bar-item">
                            <div class="menu-icon">
                                <img src="<%=request.getContextPath()%>/resources/img/clubs.png" alt="">
                            </div>
                            <div class="menu-text">
                                Clubs
                            </div>
                        </div>
                    </a>

                    <a href="<%=request.getContextPath()%>/students">
                        <div class="nav-bar-item">
                            <div class="menu-icon">
                                <img src="<%=request.getContextPath()%>/resources/img/search.png" alt="">
                            </div>
                            <div class="menu-text">
                                Search student
                            </div>
                        </div>
                    </a>

                    <a href="<%=request.getContextPath()%>/logout">
                        <div class="nav-bar-item">
                            <div class="menu-icon">
                                <img src="<%=request.getContextPath()%>/resources/img/logout.png" alt="">
                            </div>
                            <div class="menu-text">
                                Log out
                            </div>
                        </div>
                    </a>
                </div>
                <%}%>
            </div>
            <div class="col-md-9 col-sm-8 xol-xs-12">
                <div class="content">
