package ChangePassword;

import AbstractClasses.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBChangePassword extends GetConnection {


    protected boolean SelectPasswordAndEmail(int Id, String Password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean checking = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT count(Students_Email) as count FROM Student WHERE id=? and Students_Password=?");

            preparedStatement.setInt(1, Id);
            preparedStatement.setString(2, Password);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();


            checking = resultSet.getInt("count") != 0;

            resultSet.close();
            preparedStatement.close();
            connection.close();

        }
        catch (SQLException e){e.printStackTrace();}

        return checking;

    }


    protected void ChangePassword(int Id,String Password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE student set Students_Password = ? where id = ?");
            preparedStatement.setString(1, Password);
            preparedStatement.setInt(2, Id);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e){e.printStackTrace();}


    }



}
