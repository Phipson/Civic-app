package ecomap.a2017.lahacks.ecomap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by 14leec1 on 1/4/2017.
 */

public class MySQL_JavaGetValues extends MySQL_Java {


        public static void getData(String[] args, int id)
        {
            try
            {
                // create our mysql database connection
                String myDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String myUrl = "jdbc:mysql://localhost/test";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "");

                // our SQL SELECT query.
                // if you only need a few columns, specify them by name instead of using "*"
                String query = "SELECT * FROM users";

                // create the java statement
                Statement st = conn.createStatement();

                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);

                // iterate through the java resultset
                while (rs.getInt("id") != id) {
                    rs.next();
                }
                    rs.next();
                    id = rs.getInt("id");
                    String event_name = rs.getString("first_name");
                    String event_descr = rs.getString("last_name");
                    Date dateCreated = rs.getDate("date_created");
                    String uuid = rs.getString("is_admin");
                    String Location = rs.getString("num_points");

                    // print the results
                    System.out.format("%s, %s, %s, %s, %s, %s\n", id, event_name, event_descr, dateCreated, uuid, Location);
                    String date = dateCreated.toString();
                    String ID = Integer.toString(id);

                    // set the results
                    args[1] = event_name;
                    args[2] = event_descr;
                    args[3] = date;
                    args[4] = uuid;
                    args[5] = Location;

                st.close();
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
    }

