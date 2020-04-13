package StepDefinitions.iceHrm;

import Pages.IceHRM.IceHrmHomePage;
import Pages.IceHRM.IceHrmLANGUAGE;
import Pages.IceHRM.SalaryPage;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LanguageSteps {
    WebDriver driver = Driver.getDriver();
    IceHrmLANGUAGE languagePage = new IceHrmLANGUAGE();
    @Given("the user click language tab")
    public void the_user_click_language_tab() {
        languagePage.languageButton.click();
    }

    @Given("the user validate languages")
    public void the_user_validate_languages(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> ExpectedPersonInfo = dataTable.asMap(String.class,String.class);
        Map<String ,String > actualPersonInfo=languagePage.getKeysAndValues(languagePage.shortNames,languagePage.longNames);
        Set<String> keys=ExpectedPersonInfo.keySet();
        for (String key: keys){
            Assert.assertEquals(ExpectedPersonInfo.get(key),actualPersonInfo.get(key));
        }
    }
    @Then("the user validate languages with short names with header")
    public void the_user_validate_languages_with_short_names_with_header(List<Map<String ,String >> ListOfLanguages){
        for (Map<String,String> map: ListOfLanguages){
            if (map.get("Name").equals("tt")){
                System.out.println(map.get("Description"));
                System.out.println(map.get("Name"));
            }
        }

    }


}
