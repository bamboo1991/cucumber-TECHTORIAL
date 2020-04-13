package Pages.OrderPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyOrdersPage {
    public EtsyOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderButton;
    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement selectButton;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantityField;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$cardList']")
    public List<WebElement> cardTypes;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNumberField;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expireCard;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processButton;

    public void selectCard(String cardName){
        switch (cardName){
            case "Visa":
                this.cardTypes.get(0).click();
                break;
            case "MasterCard":
                this.cardTypes.get(1).click();
                break;
            case "American Express":
                this.cardTypes.get(2).click();
                break;
        }
    }



}
