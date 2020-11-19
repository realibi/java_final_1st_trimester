package MajorAdmin;

import AbstractClasses.GetConnection;
import ListOfClubs.ListOfClass;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DBSelectAllClubs extends GetConnection {

    protected Queue<SelectAllClubs> SelectAllClubs(){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Queue<SelectAllClubs> selectAllClubsList = new ArrayDeque<>();

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select ListOfClubs.Id, Club_Title, Club_Description, Students_Email, Students_name, Students_surname from Student inner join Admin on Student.Id = Admin.Student_id inner join ListOfClubs on Admin.Id = ListOfClubs.Admin_id");

            while (resultSet.next()){
                SelectAllClubs selectAllClubs = new SelectAllClubs();
                selectAllClubs.setId(resultSet.getInt("Id"));
                selectAllClubs.setTitle(resultSet.getString("Club_Title"));
                selectAllClubs.setDescription(resultSet.getString("Club_Description"));
                selectAllClubs.setEmail(resultSet.getString("Students_Email"));
                selectAllClubs.setName(resultSet.getString("Students_name"));
                selectAllClubs.setSurname(resultSet.getString("Students_surname"));

                selectAllClubsList.add(selectAllClubs);

            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return selectAllClubsList;

        }

        protected void UpdateClubs(String title, String description, int Club_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update listofclubs set Club_Title = ?, Club_Description = ? where Id = ?");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, Club_id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}
    }

    protected void DeleteClub(int Clubs_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from listofclubs where Id = ?");
            preparedStatement.setInt(1, Clubs_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }

    protected void DeleteAllInNews(int ClubId){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from news where Club_Id = ?");
            preparedStatement.setInt(1, ClubId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }
    protected void DeleteAllInEvents(int ClubId){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from events where Club_Id = ?");
            preparedStatement.setInt(1, ClubId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }

    protected void ChangeStatusToUsers(int Club_id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update Student set Students_Status = 'User' where id = (Select Student_id from Moderators where Clubs_id = ?)");
            preparedStatement.setInt(1, Club_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }

    protected void DeleteAllModerators(int Club_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from moderators where Clubs_Id = ?");
            preparedStatement.setInt(1, Club_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }

    protected void ChangeStatusOfAdmin(int Student_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update Student set Students_Status = 'User' where id = ?");
            preparedStatement.setInt(1, Student_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }
    protected void DeleteFromAdmin(int Student_id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from admin where Student_id = ?");
            preparedStatement.setInt(1, Student_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}
    }
    protected int SelectStudent_id(int Club_id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Student_id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Student.Id from Student inner join Admin on Student.Id = Admin.Student_Id inner join ListOfClubs on Admin.Id = ListOfClubs.Admin_id where ListOfClubs.Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Student_id = resultSet.getInt("Id");

            preparedStatement.close();
            resultSet.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}
        return Student_id;
    }

}
