package ListOfClubByAdmin;

import AbstractClasses.GetConnection;
import ListOfClubs.ListOfClass;

import java.sql.*;
import java.util.ArrayList;

public class DBClubByAdmin extends GetConnection {

    protected ArrayList<ClubByAdmin> SelectAllClubs(int Student_id){

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<ClubByAdmin> clubByAdmins = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select ListOfClubs.Id, Club_Title, Club_Description, Students_Email, Students_name, Students_surname from Student inner join Admin on Student.Id = Admin.Student_id inner join ListOfClubs on Admin.Id = ListOfClubs.Admin_id where Student.id = ?");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ClubByAdmin clubByAdmin = new ClubByAdmin();
                clubByAdmin.setId(resultSet.getInt("Id"));
                clubByAdmin.setTitle(resultSet.getString("Club_Title"));
                clubByAdmin.setDescription(resultSet.getString("Club_Description"));
                clubByAdmin.setEmail(resultSet.getString("Students_Email"));
                clubByAdmin.setName(resultSet.getString("Students_name"));
                clubByAdmin.setSurname(resultSet.getString("Students_surname"));

                clubByAdmins.add(clubByAdmin);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return clubByAdmins;
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

    protected void DeleteClub(int Admin_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from listofclubs where Admin_id = ?");
            preparedStatement.setInt(1, Admin_id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}
    }

    protected int SelectAdminId(int Student_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int AdminId = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT id from admin where Student_id = ?");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            AdminId = resultSet.getInt("id");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return AdminId;
    }

    protected int SelectClubId(int AdminId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int ClubId = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT Id from listofclubs where Admin_id = ?");
            preparedStatement.setInt(1, AdminId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ClubId = resultSet.getInt("Id");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return ClubId;
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

    protected void UpdateClubByAdmin(String Title, String description, int AdminId){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update listofclubs set Club_Title = ?, Club_Description = ? where Admin_id = ?");
            preparedStatement.setString(1,Title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, AdminId);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }



}
