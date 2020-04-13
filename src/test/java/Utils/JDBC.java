package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        Connection connetion = DriverManager.getConnection(
                "jdbc:oracle:thin:@techotrialdb.c2cuobkpe1em.us-east-2.rds.amazonaws.com:1521:xe",
                "hr",
                "hr");
        Statement statement = connetion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.beforeFirst();
        resultSet.next();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("FIRST_NAME"));
//
//        }
        resultSet.last();
        System.out.println(resultSet.getRow());

        // Working with database MetaData to get data base details(columns,username..)
        DatabaseMetaData metaData = connetion.getMetaData();
        System.out.println("User: "+metaData.getUserName());
        System.out.println("Database data: "+metaData.getDatabaseProductName());
        System.out.println(metaData.getConnection());
        //ResultSetMetaData -> to get Column number and column names of executed query.
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("Columns number: "+resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(1));
        System.out.println(resultSetMetaData.getColumnTypeName(1));




        resultSet.first();
        for (int i =1; i<resultSetMetaData.getColumnCount();i++){
            System.out.println(resultSetMetaData.getColumnName(i));
        }
        List<Map<String,Object>> data = new ArrayList();
        while (resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            for (int i =1; i<=resultSetMetaData.getColumnCount();i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        System.out.println(data);
        System.out.println("+++++++++++++++++++ Salaries+++++++++++++++++++++++++");




        for (int i =1; i<data.size(); i++){
            System.out.println(data.get(i).get("SALARY"));
        }




    }
}
