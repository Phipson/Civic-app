package ecomap.a2017.lahacks.ecomap;

import java.sql.*;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by 14leec1 on 1/4/2017.
 */

public class MySQL_Java {

    public static void getConnection (String[] args)
    {
        try
        {
            // create a mysql database connection
            String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String myUrl = "jdbc:sqlserver://localhost:3306/ecomap";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into events (id, event_name, event_description, location, uuid, time)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, 'A');
            preparedStmt.setString (2, "B");
            preparedStmt.setString(3, "C");
            preparedStmt.setString (4, "D");
            preparedStmt.setString(5, "E");
            preparedStmt.setDate   (6, startDate);
            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}
