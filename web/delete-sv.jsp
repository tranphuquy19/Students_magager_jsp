<%@ page import="models.Bean.Student" %>
<%@ page import="utils.Constants" %>
<%@ page import="models.Bean.Faculty" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 06/11/2019
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa sinh viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link rel="shortcut icon" type="image/png" href="./dist/img/team.png"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./dist/css/bootstrap.min.css">
    <%--    Font Awesome--%>
    <link rel="stylesheet" type="text/css" href="./dist/css/all.css">
</head>
<body>
<div class="container-fluid bg-light">
    <%@include file="nav-bar.jsp" %>
    <%Student student = (Student) request.getAttribute(Constants.ATT_STUDENT);%>
    <div class="card col-6 m-5">
        <div class="row">
            <div class="card-body">
                <h5 class="card-title"><b>Xóa sinh viên</b></h5>
                <form action="<%=request.getContextPath()%>/students-update" method="post">
                    <%--                    Input field mssv--%>
                    <div class="form-row">
                        <label for="id" class="col-md-2 col-form-label">MSSV</label>
                        <div class="form-group col-md-10">
                            <input type="number" class="form-control" name="id" id="id"
                                   value="<%=student.getId()%>" readonly>
                        </div>
                    </div>
                    <%--    Input field name--%>
                    <div class="form-row">
                        <label for="name" class="col-md-2 col-form-label">Họ tên</label>
                        <div class="form-group col-md-10">
                            <input type="text" class="form-control" name="name" id="name"
                                   value="<%= student.getName()%>" readonly>
                        </div>
                    </div>
                    <%--    Input field gender--%>
                    <div class="form-row">
                        <label class="col-md-2 control-label">Giới tính</label>
                        <div class="row col-md-10 pl-5">
                            <div class="form-check col-md-6">
                                <input type="radio" class="form-check-input" name="isMale" id="male1" value="true"
                                       checked>
                                <label for="male1" class="form-check-label">Nam</label>
                            </div>
                            <div class="form-check col-md-6 pr-3">
                                <input type="radio" class="form-check-input" name="isMale" id="male2" value="false">
                                <label for="male2" class="form-check-label">Nữ</label>
                            </div>
                        </div>
                    </div>
                    <%--    Input field faculty--%>
                    <div class="form-row">
                        <label for="facultyId" class="col-md-2 col-form-label">Khoa</label>
                        <div class="form-group col-md-10">
                            <select name="facultyId" id="facultyId" class="form-control" disabled>
                                <option value="<%= Constants.DEFAULT_SELECTED%>" selected>---Chọn khoa---</option>
                                <% ArrayList<Faculty> faculties = (ArrayList<Faculty>) request.getAttribute(Constants.FACULTIES_LIST);
                                    for (Faculty faculty : faculties) { %>
                                <option value="<%=faculty.getName()%>"><%=faculty.getName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <%--    button--%>
                    <div class="form-row">
                        <div class="col-md-2"></div>
                        <div class="col-md-10">
                            <button class="btn btn-danger" type="button" onclick="deleteSV()">Xóa</button>
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
<script src="./dist/js/jquery-3.4.1.min.js"></script>
<script src="./dist/js/popper.min.js"></script>
<script src="./dist/js/bootstrap.min.js"></script>
<script>
    function deleteSV(){
        var result = confirm("Xác nhận xóa?");
        if(result == true){
            console.log(123);
            $.post('<%= request.getContextPath() + "/students-delete"%>', {id: <%=student.getId()%>});
        }
    }
    $('#facultyId').val('<%= student.getFaculty()%>');
    $("input[name=isMale][value=" + <%=String.valueOf(student.getMale())%> +"]").attr('checked', 'checked');
</script>
</body>
</html>
