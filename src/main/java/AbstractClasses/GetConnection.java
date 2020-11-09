package AbstractClasses;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class GetConnection {


    protected Connection getConnection()
    {
        Context initialContext = null;
        Connection connection = null;
        try
        {
            initialContext = new InitialContext();
            Context envCtx = (Context)initialContext.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/week");
            connection = ds.getConnection();
        }
        catch (NamingException | SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

}
