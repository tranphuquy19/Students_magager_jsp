package models.BO;

import models.Bean.User;
import models.DAO.UserDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class UserBO {
    public static User getUser(String username, String password) {
        User user = null;
        try {
            ResultSet rs = UserDAO.getUserResultSet(username, password);

            if (rs.next()) { // Chỉ lấy bảng ghi đầu tiên
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User getUser(String username){
        User user = null;
        try{
            ResultSet rs = UserDAO.getUserResultSet(username);
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
