package Pages.IceHRM;

import Utils.Driver;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceHrmHomePage {
    public IceHrmHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[.='Admin']")
    public WebElement adminBtn;
    @FindBy(xpath = "//ul[@id='admin_Admin']//li")
    public List<WebElement> adminHeaders;
    @FindBy(xpath = "//span[.='Personal Information']")
    public WebElement personalInfoBtn;
    @FindBy(xpath = "//ul[@id='module_Personal_Information']//li")
    public List<WebElement> personalListInfo;
    @FindBy(xpath = "//i[@class='fa fa-check-square']")
    public WebElement qualificationButton;
    @FindBy(id = "tabEducation")
    public WebElement educationButton;
    @FindBy(xpath = "//div[@id='tabPageEducation']//td[1]")
    public List<WebElement> personalInfoNames;
@FindBy(xpath = "//div[@id='tabPageEducation']//td[2]")
public List<WebElement> personalInfoValues;

public Map<String, String > getKeysAndValues(List<WebElement> keys,List<WebElement> values){
    Map<String, String> allInfo =new HashMap<>();
    for (int i =0; i<keys.size(); i++){
        allInfo.put(keys.get(i).getText(), values.get(i).getText());
    }
    return allInfo;
}

}
