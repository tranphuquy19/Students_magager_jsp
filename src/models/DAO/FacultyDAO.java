package models.DAO;

import database.DBConnect;
import sun.security.pkcs11.Secmod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tranphuquy19@gmail.com
 * @since 02/11/2019
 */
public class FacultyDAO {
    public static ResultSet getFacultiesResultSet() throws SQLException, ClassNotFoundException {
        String sqlString = "Select * From faculty";

        Statement statement = DBConnect.getConnection().createStatement();
        return statement.executeQuery(sqlString);
    }

    public static ResultSet getFacultyById(int facultyId) throws SQLException, ClassNotFoundException {
        String preSqlString = "Select a.id, a.name From faculty a Where a.id = ?";

        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
        preparedStatement.setInt(1, facultyId);
        return preparedStatement.executeQuery();
    }
}
