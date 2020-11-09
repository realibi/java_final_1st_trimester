package ChangePassword;

import AbstractClasses.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBChangePassword extends GetConnection {


    protected boolean SelectPasswordAndEmail(String Email, String Password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean checking = false;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT count(Students_Email) as count FROM Student WHERE Students_Email=? and Students_Password=?");

            preparedStatement.setString(1, Email);
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


    protected void ChangePassword(String Email,String Password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE student set Students_Password = ? where Students_Email = ?");
            preparedStatement.setString(1, Password);
            preparedStatement.setString(2, Email);

            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e){e.printStackTrace();}


    }



}
