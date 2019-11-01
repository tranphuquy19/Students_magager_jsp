package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tranphuquy19@gmail.com
 * @since 30/10/2019
 */
public class DBConnect {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/student_manager";
        String usernameDB = "root";
        String passwdDB = "root@123";

        return DriverManager.getConnection(connectionString, usernameDB, passwdDB);
    }
}
