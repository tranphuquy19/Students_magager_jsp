package models.DAO;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class UserDAO {
    public static ResultSet getUserResultSet(String username, String password) throws SQLException, ClassNotFoundException {
        String preSqlString = "Select a.username, a.password From user a Where a.username = ? and a.password = ?";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        return preparedStatement.executeQuery();
    }

}
