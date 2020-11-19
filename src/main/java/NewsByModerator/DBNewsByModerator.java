package NewsByModerator;

import AbstractClasses.GetConnection;
import NewsByClub.NewsByClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBNewsByModerator extends GetConnection {


    protected ArrayList<NewsByModerator> SelectNewsByModerator(int Student_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<NewsByModerator> newsByModerators = new ArrayList<>();


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Id, News_Title, News_description from news where Club_Id = (select Clubs_Id from Moderators where Student_id = ?);");
            preparedStatement.setInt(1, Student_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                NewsByModerator newsByModerator = new NewsByModerator();

                newsByModerator.setId(resultSet.getInt("Id"));
                newsByModerator.setTitle(resultSet.getString("News_Title"));
                newsByModerator.setDescription(resultSet.getString("News_description"));
                newsByModerators.add(newsByModerator);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newsByModerators;
    }

    protected void DeleteNews(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("delete from news where Id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void UpdateNews(String Title, String Description, int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("update news set News_Title = ?, News_description = ? where Id = ?");
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
    protected void CreateNews(String Title, String Description, int Club_id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into news(News_Title, News_description, Club_Id) value(?, ?, ?)");
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
