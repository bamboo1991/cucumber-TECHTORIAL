package StepDefinitions.WebOrderStepDefinitions;

import Pages.WebOrderPage.AllOrdersPage;
import Pages.WebOrderPage.AllProductPage;
import Pages.WebOrderPage.EditOrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebOrderEditOrderStepDefs {
    EditOrderPage page = new EditOrderPage();
    AllOrdersPage allOrdersPage = new AllOrdersPage();
    @When("the user change customerName {string}")
    public void the_user_change_customerName(String customerName) {
      page.name.clear();
       page.name.sendKeys(customerName);
    }
    @Then("the user change street {string}")
    public void the_user_change_street(String street) {
        page.street.clear();
        page.street.sendKeys(street);
    }
    @Then("the user change city {string}")
    public void the_user_change_city(String city) {
        page.city.clear();
        page.city.sendKeys(city);
    }
    @Then("the user change state {string}")
    public void the_user_change_state(String state) {
        page.state.clear();
        page.state.sendKeys(state);
    }
    @Then("the user change zip {string}")
    public void the_user_change_zip(String zipCode) {
       page.zip.clear();
        page.zip.sendKeys(zipCode);
    }
    @Given("the user click edit button")
    public void the_user_click_edit_button() {
        allOrdersPage.editButton.click();

    }
    @When("the user click update button")
    public void the_user_click_update_button() {
       page.updateButton.click();
    }
    @Then("the user validate updated order info {string} {string} {string} {string} {string}")
    public void the_user_validate_updated_order_info(String expectedName, String expectedStreetName, String expectedCityName,
                                                     String expectedState, String expectedZip) {
        List<WebElement> orderInfos=page.orderInfoTable;
        String actualCustomerName=orderInfos.get(1).getText();
        String actualStreetName = orderInfos.get(5).getText();
        String actualCityName = orderInfos.get(6).getText();
        String actualState = orderInfos.get(7).getText();
        String actualZip = orderInfos.get(8).getText();

        Assert.assertTrue(actualCustomerName.equals(expectedName));
        Assert.assertTrue(actualStreetName.equals(expectedStreetName));
        Assert.assertTrue(actualCityName.equals(expectedCityName));
        Assert.assertTrue(actualState.equals(expectedState));
        Assert.assertTrue(actualZip.equals(expectedZip));

    }
}
