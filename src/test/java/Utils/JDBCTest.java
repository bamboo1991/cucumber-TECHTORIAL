package Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        DBUTILS.establishConnection();
        List<Map<String,Object>> queryResult = DBUTILS.runQuery("select FIRST_NAME, last_name, salary from employees");
        System.out.println(queryResult.get(0).get("LAST_NAME"));
        System.out.println(queryResult.get(0).get("FIRST_NAME"));


    }
}
