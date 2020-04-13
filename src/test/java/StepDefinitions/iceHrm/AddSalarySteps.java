package StepDefinitions.iceHrm;

import Pages.IceHRM.SalaryPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class AddSalarySteps {
    WebDriver driver = Driver.getDriver();
    SalaryPage salaryPage = new SalaryPage();

    @Given("the user navigate to iceHRM website")
    public void the_user_navigate_to_iceHRM_website() {
        driver.get(ConfigReader.getProperty("iceHrmUrl"));
    }

    @When("the user provide iceHRM username {string}")
    public void the_user_provide_iceHRM_username(String username) {
        salaryPage.userName.sendKeys(username);
    }

    @When("the user provide iceHRM password {string}")
    public void the_user_provide_iceHRM_password(String password) {
        salaryPage.password.sendKeys(password);
    }

    @Then("the user click sing in button")
    public void the_user_click_sing_in_button() {
        salaryPage.signInBtn.click();
    }

    @Given("the user click the payroll")
    public void the_user_click_the_payroll() {
        salaryPage.payRollBtn.click();
    }

    @Given("the user click the salary button")
    public void the_user_click_the_salary_button() {
        salaryPage.salaryBtn.click();
    }

    @Given("the user click the add new button")
    public void the_user_click_the_add_new_button() {
        salaryPage.addNewBtn.click();
    }

    @Given("the user will enter the code {string}")
    public void the_user_will_enter_the_code(String code) {
        salaryPage.codeField.sendKeys(code);
    }

    @Given("the user enter the name {string}")
    public void the_user_enter_the_name(String name) {
        salaryPage.nameField.sendKeys(name);
    }

    @Given("the user click the save button")
    public void the_user_click_the_save_button() {
        salaryPage.saveBtn.click();
    }

    @Then("the user validate {string} and {string} are saved")
    public void the_user_validate_and_are_saved(String expectedCode, String expectedName) throws InterruptedException {
        salaryPage.findLastPage();
        String actual = salaryPage.lastCode.getText();
        String actualName = salaryPage.lastName.getText();
        Thread.sleep(1000);
        Assert.assertTrue(actual.equals(expectedCode));
        Assert.assertTrue(actualName.equals(expectedName));
    }
}
