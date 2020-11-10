package CreateRequestClub;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBCreateClubRequest extends GetConnection {

    protected void InsertInfoToRequestClub(String Club_Title, String Club_Description, int User_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT into requestclub(Club_Title, Club_Description, Admin_id) value (?, ?, ?)");

            preparedStatement.setString(1, Club_Title);
            preparedStatement.setString(2, Club_Description);
            preparedStatement.setInt(3, User_id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    protected void InsertToAdmin(int Admin_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into admin(Student_id) value(?)");
            preparedStatement.setInt(1, Admin_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected int SelectAdminId(int Student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT Id from admin where Student_id =?");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Id = resultSet.getInt("Id");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Id;
    }



}
