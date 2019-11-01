<%@ page import="utils.Constains" %><%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 31/10/2019
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Đăng nhập hệ thống</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="icon" href="data:,">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./dist/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3">
    <% if ("true".equals(request.getAttribute(Constains.ATT_LOGIN_FAILED))) {%>
    <div class="alert alert-danger" role="alert">
        Username or Password was wrong!
    </div>
    <%}%>
    <div class="card col-4 mx-auto my-auto align-middle">
        <div class="row">
            <div class="card-body">
                <h5 class="card-title">Đăng nhập hệ thống</h5>
                <form action="<%=request.getContextPath()%>/login" method="post">
                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <input type="text" class="form-control" name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <input class="form-control" type="password" name="password" id="password">
                    </div>
                    <button class="btn btn-primary float-right" type="reset">Hủy</button>
                    <button class="btn btn-primary float-right mr-2" type="submit">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./dist/js/jquery-3.3.1.slim.min.js"></script>
<script src="./dist/js/popper.min.js"></script>
<script src="./dist/js/bootstrap.min.js"></script>
</body>
</html>
