package Pages.IceHRM;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalaryPage {
    public SalaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@onclick='submitLogin();return false;']")
    public WebElement signInBtn;
    @FindBy(xpath = "//span[.='Payroll']")
    public WebElement payRollBtn;
    @FindBy(xpath = "//i[@class='fa fa-money-check-alt']//..")
    public WebElement salaryBtn;
    @FindBy(xpath = "//button[.='Add New ']")
    public WebElement addNewBtn;
    @FindBy(xpath = "//input[@id='code']")
    public WebElement codeField;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;
    @FindBy(xpath = "//button[.=' Save']")
    public WebElement saveBtn;
    @FindBy(xpath = "//ul[@class='pagination']//a")
    public List<WebElement> pagination;
    @FindBy(xpath = "//table[@id='grid']//tbody//tr[last()]//td[1]")
    public WebElement lastCode;
    @FindBy(xpath = "//table[@id='grid']//tbody//tr[last()]//td[2]")
    public WebElement lastName;
    @FindBy(xpath = "//ul[@class='pagination']//li[last()]")
    public WebElement nextBtn;

    public void findLastPage() throws InterruptedException {
        int count =2;
        Thread.sleep(500);
        while (nextBtn.getAttribute("class").equals("next")){
            clickPagination(count);
            count++;
        }
    }

    public void clickLastPage(){
        pagination.get(pagination.size()-1).click();
    }
    public void clickPagination(int num) throws InterruptedException {
        String pageNumber = "" + num;
        Thread.sleep(500);
        for (WebElement element : pagination) {
            if (element.getText().equals(pageNumber)) {
                element.click();
                break;
            }
        }
    }
}
