package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

public class LoginPage {

    private WebDriver driver ;
    private By userIdBox = By.xpath("//input[@name=\"uid\"]");
    private By passwordBox = By.xpath("//input[@type=\"password\"]");
    private By loginBtn = By.xpath("//input[@name=\"btnLogin\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver ;
    }

    public void setUserId(String userId) {
        driver.findElement(userIdBox).sendKeys(userId);
    }

    public void setPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickLoginBtn (){
        driver.findElement(loginBtn).click();
    }

    public ManagerHomePage login (String userId , String password) {
        setUserId(userId);
        setPassword(password);
        clickLoginBtn();
        return new ManagerHomePage(driver);
    }


    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().LoginPageURL());
        return this;
    }


}
