<%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 31/10/2019
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Trang chính</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="shortcut icon" type="image/png" href="./dist/img/team.png"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./dist/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h1>Chương trình quản lí sinh viên</h1>
    <a class="btn btn-lg btn-warning" href="<%=request.getContextPath() + "/students"%>">Đi đến danh sách sinh viên</a>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./dist/js/jquery-3.3.1.slim.min.js"></script>
<script src="./dist/js/popper.min.js"></script>
<script src="./dist/js/bootstrap.min.js"></script>
</body>
</html>
