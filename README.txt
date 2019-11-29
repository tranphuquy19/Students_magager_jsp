Chương trình quản lí sinh viên

------------------------CÁC RESOURCES------------------------
Các trang JSP chính
1. 404.jsp              Trả về khi đối tượng không được tìm thấy
2. delete-sv.jsp        Trang xóa sinh viên
3. index.jsp            Trang chủ
4. login.jsp            Trang đang nhập
5. nav-bar.jsp          Header của các trang
6. new-sv.jsp           Trang tạo sinh viên
7. search-results.jsp   Trang hiển thị kết quả tìm kiếm
8. update-sv.jsp        Trang chỉnh sửa sinh viên

Các Controllers
1. CheckLogin(filter)   Check người dùng đã login chưa, nếu chưa thì quay về trang đăng nhập, ngược lại thì chuyển tiếp đến controller đích
2. Login                Đăng nhập
3. Logout               Đăng xuất

4. StudentCreate        Tạo mới sinh viên
5. StudentDelete        Xóa sinh viên
6. StudentIndex         Hiển thị danh sách sinh viên
7. StudentSearch        Hiện thị danh sách sinh viên theo từ khóa
8. StudentUpdate        Chỉnh sửa sinh viên

Các lớp dùng chung(utils)
1. CharsetEncoding(filter)  Set charsetEncoding UTF-8
2. Constants                Các hằng số
3. Validator                Validate dữ liệu các form khi gửi lên


------------------------CẤU HÌNH------------------------
SQL File
1. student_manager.sql
    Mô tả: Tạo cấu trúc các bảng, quan hệ và dữ liệu các bảng
    Đường dẫn: <root-project>/docs/student_manager.sql

Các thư viện
1. mysql-connector-java-8.0.17.jar
    Mục đích sử dụng: Hỗ trợ kết nối MysqlDB
    Đường dẫn: <root-project>/lib/mysql-connector-java-8.0.17.jar

2. Jquery, Bootstrap, Font-awesome
    Mục đích sử dụng: Hỗ trợ tạo giao diện HTML
    Đường dẫn: <root-project>/web/dist/...