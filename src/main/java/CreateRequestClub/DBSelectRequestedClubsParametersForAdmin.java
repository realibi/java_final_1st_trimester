package CreateRequestClub;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;

public class DBSelectRequestedClubsParametersForAdmin extends GetConnection {

    protected ArrayList<RequestedClubsParameters> SelectRequestedClubParametersForAdmin(){

        Connection connection = null;
        ArrayList<RequestedClubsParameters> requestedClubsParametersList = new ArrayList<>();

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from requestclub");

            RequestedClubsParameters requestedClubsParameters = new RequestedClubsParameters();
            while (resultSet.next()){

                requestedClubsParameters.setTitle(resultSet.getString("Club_Title"));
                requestedClubsParameters.setEmail(resultSet.getString("Owners_Email"));
                requestedClubsParameters.setName(resultSet.getString("Owners_Name"));
                requestedClubsParameters.setSurname(resultSet.getString("Owners_Surname"));
                requestedClubsParameters.setDescription(resultSet.getString("Club_Description"));

                requestedClubsParametersList.add(requestedClubsParameters);

            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e){e.printStackTrace();}

        return requestedClubsParametersList;

    }

    protected void DeleteRequestedClub(String Title){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from requestclub where Club_Title = ?");
            preparedStatement.setString(1, Title);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    protected void InsertIntoListOfClubs(String Title, String Email, String Name, String Surname, String Description){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT into listofclubs(club_title, owners_email, owners_name, owners_surname, club_description) VALUE (?,?,?,?,?)");
            preparedStatement.setString(1, Title);
            preparedStatement.setString(2,Email);
            preparedStatement.setString(3,Name);
            preparedStatement.setString(4,Surname);
            preparedStatement.setString(5,Description);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

    }
    protected void ChangeStatus(String Email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Update student set Students_status = 'Admin' where Students_Email = ?");
            preparedStatement.setString(1, Email);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}
    }

}
