package AddModerators;

import AbstractClasses.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAddModerators extends GetConnection {


    protected boolean AddModerators(String Email, String Name, String Surname, String Clubs_Title){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean check = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Insert into Moderators(Moderators_Email, Moderators_Name, Moderators_Surname, Clubs_Title) value(?, ?, ?, ?)");
            preparedStatement.setString(1, Email);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Surname);
            preparedStatement.setString(4, Clubs_Title);

            preparedStatement.executeUpdate();
            check = true;

            preparedStatement.close();
            connection.close();
        }
         catch (SQLException e){e.printStackTrace();}
        return check;
    }

    protected void ChangeStatus(String Email){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Update student set Students_status = 'Moderator' where Students_Email =?");
            preparedStatement.setString(1, Email);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    protected boolean DeleteModerator(String Email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean check = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from moderators where Moderators_Email =?");
            preparedStatement.setString(1, Email);
            preparedStatement.executeUpdate();
            check = true;

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}
         return check;
    }
    protected void ChangeStatusToUser(String Email){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Update student set Students_status = 'User' where Students_Email =?");
            preparedStatement.setString(1, Email);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

    }

}
