
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author: Kevin Huang
 * Date: 3/17/13 , 6:23 PM
 * Copyright Reserved 2013
 */
public class mysqlStatement {
    protected static ArrayList<ArrayList<String >> startConnection(String queryStatement,String DBTable, String queryContraints)
    {
        Connection conn = null;


        dbcredential database = new dbcredential();


        String url = database.getOst();
        String dbName = database.getDbname();
        String driver = database.getDbdriver();
        String userName = database.getDbname();
        String password = database.getDbpass();

        ArrayList<ArrayList<String >> recordSet = new ArrayList<ArrayList<String >>();

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);

            Statement statementSQL = conn.createStatement();
            statementSQL.execute(queryStatement + " FROM " + DBTable + " " + queryContraints);
            ResultSet rs = statementSQL.getResultSet();

            while (rs.next()) {
                Integer i ;
                ArrayList<String> oneRow = new ArrayList<String>();
                for( i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    oneRow.add(rs.getString(i));
                }
                recordSet.add(oneRow);

            }

            conn.close();
            return recordSet;
        } catch (Exception e) {
            System.out.println("Connection failed, check your statement!");
            return null;
        }
    }

}