package StepDefinitions.EtsyStepDefs;

import Pages.EtsyPage.EtsyPage;
import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ExampleTableStepDefs {
    EtsyPage page = new EtsyPage();
    WebDriver driver = Driver.getDriver();
    @When("the user search with {string}")
    public void the_user_search_with(String searchValue) {
        page.searchBar.sendKeys(searchValue);
     page.searchButton.click();
    }
    @Then("the user validate the {string}")
    public void the_user_validate_the(String expected) {
        String actualTilte = driver.getTitle();
        Assert.assertTrue(actualTilte.equals(expected));

    }


}
