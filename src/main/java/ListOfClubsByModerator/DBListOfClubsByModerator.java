package ListOfClubsByModerator;

import AbstractClasses.GetConnection;
import ListOfClubByAdmin.ClubByAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBListOfClubsByModerator extends GetConnection {


    protected ArrayList<ListOfClubsByModerator> SelectAllClubs(int Student_id){

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<ListOfClubsByModerator> listOfClubsByModerators = new ArrayList<>();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select ListOfClubs.Id, Club_Title, Club_Description, Students_Email, Students_name, Students_surname from Student inner join Admin on Student.Id = Admin.Student_id inner join ListOfClubs on Admin.Id = ListOfClubs.Admin_id where Student.id = (select Student.Id from Moderators inner join ListOfClubs on Moderators.Clubs_Id = ListOfClubs.Id inner join Admin on ListOfCLubs.Admin_Id = Admin.Id inner join Student on Admin.Student_Id = Student.Id where Moderators.Student_id = ?)");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ListOfClubsByModerator listOfClubsByModerator = new ListOfClubsByModerator();
                listOfClubsByModerator.setId(resultSet.getInt("Id"));
                listOfClubsByModerator.setTitle(resultSet.getString("Club_Title"));
                listOfClubsByModerator.setDescription(resultSet.getString("Club_Description"));
                listOfClubsByModerator.setEmail(resultSet.getString("Students_Email"));
                listOfClubsByModerator.setName(resultSet.getString("Students_name"));
                listOfClubsByModerator.setSurname(resultSet.getString("Students_surname"));

                listOfClubsByModerators.add(listOfClubsByModerator);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return listOfClubsByModerators;
    }

    protected void UpdateClubByModerator(String title, String description, int Student_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE listofclubs set Club_Title =?, Club_Description = ? where Id = (select Clubs_Id from moderators where Student_id = ?)");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, Student_id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

    }

}
