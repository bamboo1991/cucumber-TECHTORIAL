package StepDefinitions.iceHrm;

import Pages.IceHRM.IceHrmHomePage;
import Pages.WebOrderPage.HomePage;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.Set;

public class QualificationSteps {
    IceHrmHomePage homePage = new IceHrmHomePage();

    @Given("the user click qualification setup button")
    public void the_user_click_qualification_setup_button() {
        homePage.qualificationButton.click();
    }

    @Then("the user click education tab")
    public void the_user_click_education_tab() {
        homePage.educationButton.click();
    }

    @Then("the user validate personal info")
    public void the_user_validate_personal_info(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> ExpectedPersonInfo = dataTable.asMap(String.class,String.class);
        Map<String ,String > actualPersonInfo=homePage.getKeysAndValues(homePage.personalInfoNames,homePage.personalInfoValues);
        Set<String> keys=ExpectedPersonInfo.keySet();
        for (String key: keys){
            Assert.assertEquals(ExpectedPersonInfo.get(key),actualPersonInfo.get(key));
        }

    }
}
