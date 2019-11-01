<%--
  Created by IntelliJ IDEA.
  User: tranphuquy19
  Date: 02/11/2019
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <a class="navbar-brand" href="#">Quản lí sinh viên</a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
            aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="<%= request.getContextPath() + "/students"%>">Danh sách sinh viên <span
                        class="sr-only">(current)</span></a>
            </li>

        </ul>
        <form action="<%=request.getContextPath() + "/students-search"%>" method="get" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" id="key" name="key" placeholder="mssv, tên, khoa ...">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
            <a href="<%= request.getContextPath() + "/logout"%>" class="btn btn-danger ml-2">Đăng xuất</a>
        </form>
    </div>
</nav>
