package Filter;

import java.sql.*;
import java.util.ArrayList;

public class course_db_connect {

       public static ArrayList<String> getRecord(String dbhost, String dbuser, String dbpass,String dbtable ,String dbfield){
           Connection conn = null;
           Statement stmt = null;
           ResultSet rs = null;

           ArrayList<String> recordField =null;
           try {
               String dbURL = "jdbc:mysql://" + dbhost;
               String username = dbuser;
               String password = dbpass;

               Class.forName("com.mysql.jdbc.Driver");

               conn =
                       DriverManager.getConnection(dbURL, username, password);

               stmt = conn.createStatement();

               if (stmt.execute("select " + dbfield + " from " + dbuser + "." + dbtable)) {
                   rs = stmt.getResultSet();
               } else {
                   System.err.println("select failed");
               }
               while (rs.next()) {
                   String entry = rs.getString(1);
                   recordField.add(entry);
                   System.out.println(entry);
               }
               return recordField;

           } catch (ClassNotFoundException ex) {
               System.err.println("Failed to load mysql driver");
               System.err.println(ex);
               return recordField;
           } catch (SQLException ex) {
               System.out.println("SQLException: " + ex.getMessage());
               System.out.println("SQLState: " + ex.getSQLState());
               System.out.println("VendorError: " + ex.getErrorCode());
               return recordField;

           } finally {
               if (rs != null) {
                   try {
                       rs.close();
                   } catch (SQLException ex) { /* ignore */ }
                   rs = null;
               }
               if (stmt != null) {
                   try {
                       stmt.close();
                   } catch (SQLException ex) { /* ignore */ }
                   stmt = null;
               }
               if (conn != null) {
                   try {
                       conn.close();
                   } catch (SQLException ex) { /* ignore */ }

                   conn = null;
               }
               return recordField;
           }






       }


}
