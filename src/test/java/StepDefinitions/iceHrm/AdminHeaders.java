package StepDefinitions.iceHrm;

import Pages.IceHRM.IceHrmHomePage;
import Utils.BrowserUtils;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;


import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminHeaders {
    IceHrmHomePage homePage = new IceHrmHomePage();

    @When("the user click the admin button")
    public void the_user_click_the_admin_button() {
        homePage.adminBtn.click();
    }


    @Then("the user should see following headers")
    public void the_user_should_see_following_headers(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> ExpectedHeaders = dataTable.asList();
        List<String> actualHeaders = BrowserUtils.myListofElements(homePage.adminHeaders);
        Thread.sleep(1000);
        Assert.assertTrue(actualHeaders.containsAll(ExpectedHeaders));
    }

    @Given("the user must click personal information button")
    public void the_user_must_click_personal_information_button() throws InterruptedException {
        Thread.sleep(2000);
        homePage.personalInfoBtn.click();
    }

    @Given("the user should validate personal headers are displyed")
    public void the_user_should_validate_personal_headers_are_displyed(List<String> expectedHeaders) throws InterruptedException {
        WebDriver driver = Driver.getDriver();

        Thread.sleep(1000);
        List<String> actualHeds = BrowserUtils.myListofElements(homePage.personalListInfo);
        for (int i =0; i<expectedHeaders.size(); i++){

            Assert.assertEquals(expectedHeaders.get(i),actualHeds.get(i));

        }

    }
    @When("the user gives the personal information")
    public void the_user_gives_the_personal_information(Map<String, String> information) {
        System.out.println(information);
        Set<String> keys=information.keySet();
        for (String key:keys){
            if (information.get(key).equals("123456")){
                System.out.println(key);
            }


    }}}



