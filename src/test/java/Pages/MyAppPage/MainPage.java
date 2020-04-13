package Pages.MyAppPage;

import Utils.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table//tr[1]//td")
    public List<WebElement> tableFirstRow;
    @FindBy(xpath = "//table//tr[2]//td")
    public List<WebElement> tabl2Row;
    @FindBy(xpath = "//table//tr[3]//td")
    public List<WebElement> table3Row;
    @FindBy(xpath = "//table//tr[4]//td")
    public List<WebElement> table4Row;


}
