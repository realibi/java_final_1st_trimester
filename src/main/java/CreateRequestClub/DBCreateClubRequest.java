package CreateRequestClub;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBCreateClubRequest extends GetConnection {

    protected void InsertInfoToRequestClub(String Title, String Email,  String Name, String Surname, String Description){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT into requestclub(Club_Title, Owners_Email, Owners_Name, Owners_Surname, Club_Description) value (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, Title);
            preparedStatement.setString(2, Email);
            preparedStatement.setString(3, Name);
            preparedStatement.setString(4, Surname);
            preparedStatement.setString(5, Description);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}


    }

    protected Map<String,String> SelectNameAndSurname(String Email){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        HashMap<String, String> NameAndSurname = new HashMap<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT Students_name, Students_surname from student where Students_Email = ?");

            preparedStatement.setString(1, Email);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            NameAndSurname.put("Name",resultSet.getString("Students_name"));
            NameAndSurname.put("Surname",resultSet.getString("Students_surname"));

        }
        catch (SQLException e){e.printStackTrace();}

        return NameAndSurname;
    }



}
