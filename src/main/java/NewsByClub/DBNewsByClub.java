package NewsByClub;

import AbstractClasses.GetConnection;
import NewsByClub.NewsByClub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBNewsByClub extends GetConnection {

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

    protected ArrayList<NewsByClub> SelectNewsByClub(int Club_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<NewsByClub> newsByClubsList = new ArrayList<>();


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select Id, News_Title, News_description from news where Club_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                NewsByClub newsByClub = new NewsByClub();

                newsByClub.setId(resultSet.getInt("Id"));
                newsByClub.setTitle(resultSet.getString("News_Title"));
                newsByClub.setDescription(resultSet.getString("News_description"));
                newsByClubsList.add(newsByClub);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newsByClubsList;
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
}
