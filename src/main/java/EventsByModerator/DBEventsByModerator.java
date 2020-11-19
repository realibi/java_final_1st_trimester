package EventsByModerator;

import AbstractClasses.GetConnection;
import NewsByModerator.NewsByModerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBEventsByModerator extends GetConnection {

    protected ArrayList<EventsByModerator> SelectEventsByModerator(int Student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<EventsByModerator> eventsByModerators = new ArrayList<>();


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Id, Events_Title, Events_description from events where Club_Id = (select Clubs_Id from Moderators where Student_id = ?);");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                EventsByModerator eventsByModerator = new EventsByModerator();

                eventsByModerator.setId(resultSet.getInt("Id"));
                eventsByModerator.setTitle(resultSet.getString("Events_Title"));
                eventsByModerator.setDescription(resultSet.getString("Events_description"));
                eventsByModerators.add(eventsByModerator);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventsByModerators;
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
    protected int GetClubIdByModerator(int Student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Club_id = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Clubs_Id from moderators where Student_id = ?");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Club_id = resultSet.getInt("Clubs_Id");

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Club_id;
    }

}
