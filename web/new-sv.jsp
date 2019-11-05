<%@ page import="utils.Constants" %>
<%@ page import="models.Bean.Faculty" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Validator" %><%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 02/11/2019
  Time: 16:14
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
    <% Validator validator = (Validator) request.getAttribute(Constants.ATT_VALIDATOR); %>
    <div class="card col-6 m-5">
        <div class="row">
            <div class="card-body">
                <h5 class="card-title"><b>Thêm mới sinh viên</b></h5>
                <form action="<%=request.getContextPath()%>/students-create" method="post">
                    <%--                    Input field mssv--%>
                    <div class="form-row">
                        <label for="id" class="col-md-2 col-form-label">MSSV</label>
                        <div class="form-group col-md-10">
                            <input type="text" class="form-control <%= validator.is("id")%>" name="id" id="id"
                                   value="<%=validator.getCurrentValue("id")%>">
                            <%= validator.getFeedbackHTML("id")%>
                        </div>
                    </div>
                    <%--    Input field name--%>
                    <div class="form-row">
                        <label for="name" class="col-md-2 col-form-label">Họ tên</label>
                        <div class="form-group col-md-10">
                            <input type="text" class="form-control <%= validator.is("name")%>" name="name" id="name" value="<%= validator.getCurrentValue("name")%>">
                            <%= validator.getFeedbackHTML("name")%>
                        </div>
                    </div>
                    <%--    Input field gender--%>
                    <div class="form-row">
                        <label class="col-md-2 control-label">Giới tính</label>
                        <div class="row col-md-10 pl-5">
                            <div class="form-check col-md-6">
                                <input type="radio" class="form-check-input" name="male" id="male1" value="true"
                                       checked>
                                <label for="male1" class="form-check-label">Nam</label>
                            </div>
                            <div class="form-check col-md-6 pr-3">
                                <input type="radio" class="form-check-input" name="male" id="male2" value="false">
                                <label for="male2" class="form-check-label">Nữ</label>
                            </div>
                        </div>
                    </div>
                    <%--    Input field faculty--%>
                    <div class="form-row">
                        <label for="facultyId" class="col-md-2 col-form-label">Khoa</label>
                        <div class="form-group col-md-10">
                            <select name="facultyId" id="facultyId" class="form-control <%=validator.is("facultyId")%>">
                                <option value="<%= Constants.DEFAULT_SELECTED%>" selected>---Chọn khoa---</option>
                                <% ArrayList<Faculty> faculties = (ArrayList<Faculty>) request.getAttribute(Constants.FACULTIES_LIST);
                                    for (Faculty faculty : faculties) { %>
                                <option value="<%=faculty.getId()%>"><%=faculty.getName()%>
                                </option>
                                <%}%>
                            </select>
                            <%= validator.getFeedbackHTML("facultyId")%>
                        </div>
                    </div>
                    <%--    button--%>
                    <div class="form-row">
                        <div class="col-md-2"></div>
                        <div class="col-md-10">
                            <button class="btn btn-primary" type="submit">Lưu lại</button>
                            <a href="<%= request.getContextPath() + "/students"%>" class="btn btn-primary">Quay lại</a>
                        </div>
                    </div>
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
<script>
    $('#facultyId').val('<%= validator.getCurrentValue("facultyId")%>');
</script>
</body>
</html>
