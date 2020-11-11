package AddModerators;

import AbstractClasses.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBAddModerators extends GetConnection {


    protected boolean AddModerators(int Clubs_Id, int Student_id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean check = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Insert into Moderators(Clubs_Id, Student_id) value(?, ?)");
            preparedStatement.setInt(1, Clubs_Id);
            preparedStatement.setInt(2, Student_id);
            ;

            preparedStatement.executeUpdate();
            check = true;

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
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

    protected int SelectClub_id(int Admin_id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Club_id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select Id from listofclubs where Admin_id = ?;");
            preparedStatement.setInt(1, Admin_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Club_id = resultSet.getInt("Id");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Club_id;

    }

    protected int SelectStudent_id(String Email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Student_id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select Id from student where Students_Email = ?");
            preparedStatement.setString(1, Email);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Student_id = resultSet.getInt("Id");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Student_id;

    }

    protected void ChangeStatus(int Id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Update student set Students_status = 'Moderator' where id =?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    protected boolean CheckForCountOfModerators(int Club_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean check = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select count(Student_id) as count from moderators where Clubs_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt("count") <= 2) {
                check = true;
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    protected void DeleteModerator(int Student_id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from moderators where Student_id =?");
            preparedStatement.setInt(1, Student_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    protected void ChangeStatusToUser(int Id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Update student set Students_status = 'User' where id =?");
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}