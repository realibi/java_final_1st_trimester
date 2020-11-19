package ListOfEvents;

import AbstractClasses.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DBListOfEvents extends GetConnection {

    protected Set<ListOfEvents> SelectAllEventsByClubs(int Club_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Set<ListOfEvents> arraylistOfEvents = new HashSet<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select Events_Title, Events_description from Events where Club_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ListOfEvents listOfEvents = new ListOfEvents();
                listOfEvents.setTitle(resultSet.getString("Events_Title"));
                listOfEvents.setDescription(resultSet.getString("Events_description"));

                arraylistOfEvents.add(listOfEvents);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}

        return arraylistOfEvents;
    }

}
