package ListOfClubs;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;


public class DBListOfClubs extends GetConnection {

    protected ArrayList<ListOfClass> SelectAllClubs(){

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<ListOfClass> listOfClasses = new ArrayList<>();

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select ListOfClubs.Id, Club_Title, Club_Description, Students_Email, Students_name, Students_surname from Student inner join Admin on Student.Id = Admin.Student_id inner join ListOfClubs on Admin.Id = ListOfClubs.Admin_id");

            while (resultSet.next()){
                ListOfClass listOfClass = new ListOfClass();
                listOfClass.setId(resultSet.getInt("Id"));
                listOfClass.setTitle(resultSet.getString("Club_Title"));
                listOfClass.setDescription(resultSet.getString("Club_Description"));
                listOfClass.setEmail(resultSet.getString("Students_Email"));
                listOfClass.setName(resultSet.getString("Students_name"));
                listOfClass.setSurname(resultSet.getString("Students_surname"));

                listOfClasses.add(listOfClass);

            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return listOfClasses;
    }

    protected String CheckingStatus(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String checking = null;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select Students_status from student where id = ?");

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            checking = resultSet.getString("Students_status");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return checking;
    }
}
