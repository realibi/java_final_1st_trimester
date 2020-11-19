package ListOfNews;

import AbstractClasses.GetConnection;
import ListOfClubs.ListOfClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DBListOfNews extends GetConnection {

    protected Set<ListOfNews> SelectAllNewsByClubs(int Club_id){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Set<ListOfNews> arraylistOfNews = new HashSet<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select News_Title, News_description from news where Club_Id = ?");
            preparedStatement.setInt(1, Club_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ListOfNews listOfNews = new ListOfNews();
                listOfNews.setTitle(resultSet.getString("News_Title"));
                listOfNews.setDescription(resultSet.getString("News_description"));

                arraylistOfNews.add(listOfNews);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        }catch (SQLException e){e.printStackTrace();}
       return arraylistOfNews;
    }

}
