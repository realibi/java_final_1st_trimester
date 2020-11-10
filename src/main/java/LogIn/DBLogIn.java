package LogIn;

import AbstractClasses.GetConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBLogIn extends GetConnection {


   protected boolean SelectPasswordAndEmail(String Email, String Password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean checking = false;

     try {
         connection = getConnection();
         preparedStatement = connection.prepareStatement("SELECT count(Students_Email) as count FROM student WHERE Students_Email=? and Students_Password=?");

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

     protected Integer SelectId(String Email, String Password){
         Connection connection = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         int Id = 0;

         try {
             connection = getConnection();
             preparedStatement = connection.prepareStatement("SELECT id  FROM student WHERE Students_Email=? and Students_Password=?");

             preparedStatement.setString(1, Email);
             preparedStatement.setString(2, Password);

             resultSet = preparedStatement.executeQuery();
             resultSet.next();

             Id = resultSet.getInt("Id");

             resultSet.close();
             preparedStatement.close();
             connection.close();

         }
         catch (SQLException e){e.printStackTrace();}

         return Id;

     }
    protected Integer SelectIdForMajorAdmin(String Email, String Password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int Id = 0;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT id  FROM majoradmin WHERE Major_Admin_Email=? and Major_Admin_Password=?");

            preparedStatement.setString(1, Email);
            preparedStatement.setString(2, Password);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Id = resultSet.getInt("Id");

            resultSet.close();
            preparedStatement.close();
            connection.close();

        }
        catch (SQLException e){e.printStackTrace();}

        return Id;

    }

     protected String CheckingStatus(String Email) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String checking = null;
        
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select Students_status from student where Students_Email = ?");

            preparedStatement.setString(1, Email);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            checking = resultSet.getString("Students_status");

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e){e.printStackTrace();}

        return checking;
    }

   protected boolean CheckingForMajorAdmin(String Email, String Password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean checking = false;

        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement("Select count(Major_Admin_Email) as count from majoradmin where Major_Admin_Email =? and Major_Admin_Password = ?");
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

}
