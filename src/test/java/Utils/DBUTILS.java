package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUTILS {
    //Establish connection with our database
    //run queries which will accept parameter ----> return list of maps
    //get row number
    //close connection closeDB()  --> IT WILL close all connection made with database.
   private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void establishConnection() throws SQLException {
        connection=DriverManager.getConnection("jdbc:oracle:thin:@techotrialdb.c2cuobkpe1em.us-east-2.rds.amazonaws.com:1521:xe",
                ConfigReader.getProperty("DBUsername"),
                ConfigReader.getProperty("DBPassword"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }
        public static List<Map<String, Object>> runQuery(String queryParameter) throws SQLException {

        resultSet = statement.executeQuery(queryParameter);

        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        List<Map<String, Object>> data = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
                map.put(rsMetaData.getColumnName(i), resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        return data;
    }

        public static int getRowsNumber(String query) throws SQLException {
        resultSet=statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();

}
public static void closeConnection() throws SQLException {
        if (connection!=null){
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }


}
}
