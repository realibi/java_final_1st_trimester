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
            ResultSet resultSet = statement.executeQuery("select Club_Title, Club_Description, Students_Email, Students_name, Students_surname from Student inner join Admin on Student.Id = Admin.Student_id inner join requestclub on Admin.Id = requestclub.Admin_id;");

            while (resultSet.next()){
                RequestedClubsParameters requestedClubsParameters = new RequestedClubsParameters();
                requestedClubsParameters.setTitle(resultSet.getString("Club_Title"));
                requestedClubsParameters.setEmail(resultSet.getString("Students_Email"));
                requestedClubsParameters.setName(resultSet.getString("Students_name"));
                requestedClubsParameters.setSurname(resultSet.getString("Students_surname"));
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
    protected int SelectIdByEmail(String Email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select id from student where Students_Email = ?");
            preparedStatement.setString(1, Email);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            id = resultSet.getInt("id");
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    protected void DeleteRequestedClub(int id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from requestclub where Admin_id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    protected void DeleteFromAdmin(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Delete from admin where Student_id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void InsertIntoListOfClubs(String Title, String Description, int Admin_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT into listofclubs(Club_Title, Club_Description, Admin_id) VALUE (?,?,?)");
            preparedStatement.setString(1, Title);
            preparedStatement.setString(2, Description);
            preparedStatement.setInt(3, Admin_id);


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
