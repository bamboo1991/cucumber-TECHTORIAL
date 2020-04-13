package StepDefinitions.OrderStedDefs;

import Pages.OrderPage.EtsyOrdersPage;

import Pages.WebOrderPage.AllOrdersPage;
import Pages.WebOrderPage.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class OrdersStepDefs {
    EtsyOrdersPage page = new EtsyOrdersPage();
    HomePage homePage = new HomePage();
    AllOrdersPage allOrdersPage = new AllOrdersPage();

    @When("the user click order button")
    public void the_user_click_order_button() {
        page.orderButton.click();
    }

    @When("the user select product {string}")
    public void the_user_select_product(String Product) {
        Select select = new Select(page.selectButton);
        select.selectByVisibleText(Product);


    }

    @When("the user give the quantity {string}")
    public void the_user_give_the_quantity(String quantity) {
        page.quantityField.sendKeys(quantity);
    }

    @Then("the user choose the card {string}")
    public void the_user_choose_the_card(String cardType) {
        page.selectCard(cardType);
    }

    @Then("the user provide cardnumber {string}")
    public void the_user_provide_cardnumber(String cardNumber) {
        page.cardNumberField.sendKeys(cardNumber);
    }

    @Then("the user enter expiration date {string}")
    public void the_user_enter_expiration_date(String expireDate) {
        page.expireCard.sendKeys(expireDate);

    }

    @Then("the user click process button")
    public void the_user_click_process_button() {
        page.processButton.click();
    }

    @Then("the user click view all orders button")
    public void the_user_click_view_all_orders_button() {
        homePage.viewAllOrdersButton.click();
    }

    @Then("the user validate new odrder info {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void the_user_validate_new_odrder_info(String product, String quantity, String customer, String street,
                                                  String city, String state, String zip,
                                                  String card, String cardNumber, String expiration) {
        List<WebElement> productInfo = allOrdersPage.orderInfoTable;
        Assert.assertTrue(productInfo.get(1).getText().equals(customer));
        Assert.assertTrue(productInfo.get(2).getText().equals(product));
        Assert.assertTrue(productInfo.get(3).getText().equals(quantity));
        Assert.assertTrue(productInfo.get(5).getText().equals(street));
        Assert.assertTrue(productInfo.get(6).getText().equals(city));
        Assert.assertTrue(productInfo.get(7).getText().equals(state));
        Assert.assertTrue(productInfo.get(8).getText().equals(zip));
        Assert.assertTrue(productInfo.get(9).getText().equals(card));
        Assert.assertTrue(productInfo.get(10).getText().equals(cardNumber));
        Assert.assertTrue(productInfo.get(11).getText().equals(expiration));


    }


}
