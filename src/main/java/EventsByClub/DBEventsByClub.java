package EventsByClub;

import AbstractClasses.GetConnection;
import NewsByClub.NewsByClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBEventsByClub extends GetConnection {

    protected int SelectAdminId(int Student_id) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AdminId;
    }

    protected int SelectClubId(int AdminId) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ClubId;
    }
    protected ArrayList<EventsByClub> SelectEventsByClub(int Club_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<EventsByClub> eventsByClubs  = new ArrayList<>();


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Id, Events_Title, Events_description from events where Club_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                EventsByClub eventsByClub = new EventsByClub();

                eventsByClub.setId(resultSet.getInt("Id"));
                eventsByClub.setTitle(resultSet.getString("Events_Title"));
                eventsByClub.setDescription(resultSet.getString("Events_description"));
                eventsByClubs.add(eventsByClub);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventsByClubs;
    }


    protected void DeleteEvents(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from events where Id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void UpdateEvents(String Title, String Description, int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update events set Events_Title = ?, Events_description = ? where Id = ?");
            preparedStatement.setString(1, Title);
            preparedStatement.setString(2, Description);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void CreateEvents(String Title, String Description, int Club_id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into events(Events_Title, Events_description, Club_Id) value(?, ?, ?)");
            preparedStatement.setString(1, Title);
            preparedStatement.setString(2, Description);
            preparedStatement.setInt(3, Club_id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
