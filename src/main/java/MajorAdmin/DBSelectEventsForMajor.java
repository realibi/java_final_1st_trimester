package MajorAdmin;

import AbstractClasses.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DBSelectEventsForMajor extends GetConnection {

    protected Queue<SelectEventsForMajor> selectEventsForMajors(int Club_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Queue<SelectEventsForMajor> selectEventsForMajors = new ArrayDeque<>();


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Id, Events_Title, Events_description from events where Club_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                SelectEventsForMajor selectEventsForMajor = new SelectEventsForMajor();

                selectEventsForMajor.setId(resultSet.getInt("Id"));
                selectEventsForMajor.setTitle(resultSet.getString("Events_Title"));
                selectEventsForMajor.setDescription(resultSet.getString("Events_description"));
                selectEventsForMajors.add(selectEventsForMajor);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return selectEventsForMajors;
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
}
