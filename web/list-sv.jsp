<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Bean.Student" %>
<%@ page import="utils.Constants" %>
<%@ page import="models.Bean.Faculty" %><%--
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
    <link rel="stylesheet" type="text/css" href="./dist/css/all.css">
</head>
<body>
<div class="container-fluid bg-light">
    <%@include file="nav-bar.jsp" %>

    <div class="m-5">
        <%--        form chọn khoa--%>
        <form action="<%= request.getContextPath() + "/students"%>" method="get">
            <div class="row">
                <div class="col-md-4">
                    <select name="facultyId" id="facultyId" class="custom-select">
                        <option value="<%=Constants.DEFAULT_SELECTED%>" selected>--Chọn khoa--</option>
                        <% ArrayList<Faculty> faculties = (ArrayList<Faculty>) request.getAttribute(Constants.FACULTIES_LIST);
                            for (Faculty faculty : faculties) { %>
                        <option value="<%=faculty.getId()%>"><%=faculty.getName()%>
                        </option>
                        <%}%>
                    </select>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary">Xem</button>
                </div>
                <div class="col-md-6 align-middle">
                    <a href="<%= request.getContextPath() + "/students-create"%>" class="btn btn-primary">Tạo mới</a>
                </div>
            </div>
        </form>

        <%--            Bảng danh sách sinh viên--%>
        <table class="table table-striped table-hover table-responsive-sm">
            <thead>
            <th style="width: 15%">MSSV</th>
            <th style="width: 20%">Họ và tên</th>
            <th style="width: 15%">Giới tính</th>
            <th style="width: 35%">Khoa</th>
            <th style="width: 15%"></th>
            </thead>
            <tbody>
            <% ArrayList<Student> students = (ArrayList<Student>) request.getAttribute(Constants.STUDENTS_LIST);
                for (Student student : students) {
            %>
            <tr>
                <td><%=student.getId()%>
                </td>
                <td><%=student.getName()%>
                </td>
                <td><%=student.getMale() ? "Nam" : "Nữ"%>
                </td>
                <td><%=student.getFaculty()%>
                </td>
                <td>
                    <a href="<%=request.getContextPath() + "/students-update?id="+ student.getId()%>"
                       class="text-primary mr-3"><i class="fas fa-edit"></i></a>
                    <a href="<%=request.getContextPath() + "/students-delete?id=" + student.getId()%>"
                       class="text-primary"><i class="far fa-trash-alt"></i></a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./dist/js/jquery-3.3.1.slim.min.js"></script>
<script src="./dist/js/popper.min.js"></script>
<script src="./dist/js/bootstrap.min.js"></script>
</body>
</html>
