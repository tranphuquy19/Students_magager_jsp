<%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 31/10/2019
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="icon" href="data:,">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./dist/css/bootstrap.min.css">
    <%--    Font Awesome--%>
<%--    <link rel="stylesheet" type="text/css" href="./dist/css/all.css">--%>
    <script src="https://kit.fontawesome.com/455b3a19ce.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-3">
    <form action="<%= request.getContextPath() + "/students"%>" method="get">
        <div class="row">
            <div class="col-md-4">
                <select name="faculty" id="faculty" class="custom-select">
                    <option value="" selected>--Chọn khoa--</option>
                    <option value="1">Công nghệ thông tin</option>
                    <option value="2">Điện tử viễn thông</option>
                    <option value="3">Khoa hóa</option>
                    <option value="4">Điện dân dụng</option>
                </select>
            </div>
            <div class="col-md-2">
                <button type="submit" class="btn btn-primary">Xem</button>
            </div>
            <div class="col-md-6 mx-auto my-auto align-middle">
                <a href="<%= request.getContextPath() + "/students-create"%>" class="btn btn-primary">Tạo mới</a>
            </div>
        </div>
    </form>

    <table class="table table-striped table-hover table-responsive-sm">
        <thead>
        <th>MSSV</th>
        <th>Họ và tên</th>
        <th>Giới tính</th>
        <th>Khoa</th>
        <th></th>
        </thead>
        <tbody>
        <tr>
            <td>102160258</td>
            <td>Trần Phú Quy</td>
            <td>Nam</td>
            <td>Công nghệ thông tin</td>
            <td>
                <a href="#" class="text-primary mr-3"><i class="fas fa-edit"></i></a>
                <a href="#" class="text-primary"><i class="far fa-trash-alt"></i></a>
            </td>
        </tr><tr>
            <td>102160258</td>
            <td>Trần Phú Quy</td>
            <td>Nam</td>
            <td>Công nghệ thông tin</td>
            <td>
                <a href="#" class="text-primary mr-3"><i class="fas fa-edit"></i></a>
                <a href="#" class="text-primary"><i class="far fa-trash-alt"></i></a>
            </td>
        </tr>
        <tr>
            <td>102160258</td>
            <td>Trần Phú Quy</td>
            <td>Nam</td>
            <td>Công nghệ thông tin</td>
            <td>
                <a href="#" class="text-primary mr-3"><i class="fas fa-edit"></i></a>
                <a href="#" class="text-primary"><i class="far fa-trash-alt"></i></a>
            </td>
        </tr>




        </tbody>
    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./dist/js/jquery-3.3.1.slim.min.js"></script>
<script src="./dist/js/popper.min.js"></script>
<script src="./dist/js/bootstrap.min.js"></script>
</body>
</html>
