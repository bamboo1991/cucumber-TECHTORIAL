package StepDefinitions.MyApplicationStepDefs;

import Pages.MyAppPage.MainPage;
import Utils.ConfigReader;
import Utils.DBUTILS;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAppSteps {
    WebDriver driver = Driver.getDriver();
     List<Map<String, Object>> listOfUi = new ArrayList<>();

    @Given("User navigate to MyApplication page")
    public void user_navigate_to_MyApplication_page() {
        driver.get(ConfigReader.getProperty("MyApp"));
    }

    @Then("User gets data from UI Table")
    public void user_gets_data_from_UI_Table() {
        MainPage mainPage = new MainPage();
        Map<String, Object> uiRow1 = new HashMap();
        uiRow1.put("FIRST_NAME", mainPage.tableFirstRow.get(0).getText());
        uiRow1.put("LAST_NAME", mainPage.tabl2Row.get(1).getText());
        uiRow1.put("EMPLOYEE_ID", mainPage.table3Row.get(2).getText());
        listOfUi.add(uiRow1);

        Map<String, Object> uiRow2 = new HashMap();
        uiRow2.put("FIRST_NAME", mainPage.tabl2Row.get(0).getText());
        uiRow2.put("LAST_NAME", mainPage.tabl2Row.get(1).getText());
        uiRow2.put("EMPLOYEE_ID", mainPage.tabl2Row.get(2).getText());
        listOfUi.add(uiRow2);


        Map<String, Object> uiRow3 = new HashMap();
        uiRow3.put("FIRST_NAME", mainPage.table3Row.get(0).getText());
        uiRow3.put("LAST_NAME", mainPage.table3Row.get(1).getText());
        uiRow3.put("EMPLOYEE_ID", mainPage.table3Row.get(2).getText());
        listOfUi.add(uiRow3);

        Map<String, Object> uiRow4 = new HashMap();
        uiRow4.put("FIRST_NAME", mainPage.table4Row.get(0).getText());
        uiRow4.put("LAST_NAME", mainPage.table4Row.get(1).getText());
        uiRow4.put("EMPLOYEE_ID", mainPage.table4Row.get(2).getText());
        listOfUi.add(uiRow4);
    }

    @Then("User verify UI IS matched with DataBase data")
    public void user_verify_UI_IS_matched_with_DataBase_data() throws SQLException {
        DBUTILS.establishConnection();
        List<Map<String, Object>> lisOfMaps = DBUTILS.runQuery("select first_name, last_name, employee_id from employees");
        DBUTILS.closeConnection();
        Assert.assertTrue(lisOfMaps.containsAll(listOfUi));
        int count = 0;
        for (int i =0 ; i<listOfUi.size();i++){
            for (int a =0; a<listOfUi.size();a++){
                if (listOfUi.get(i).get("EMPLOYEE_ID").toString().equals(lisOfMaps.get(a).get("EMPLOYEE_ID").toString())){
                    Assert.assertEquals(listOfUi.get(i).get("FIRST_NAME").toString(),listOfUi.get(a).get("FIRST_NAME").toString());
                    Assert.assertEquals(listOfUi.get(i).get("LAST_NAME").toString(),listOfUi.get(a).get("LAST_NAME").toString());
                    count++
;                }
            }
        }
        Assert.assertEquals(4,count);
    }

}
