package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomePage {

    private WebDriver driver ;
    private By managerIdText = By.xpath("//td[contains(text(),\"mngr\")]");



    public ManagerHomePage(WebDriver driver) {
        this.driver = driver ;
    }

    public boolean managerIdIsDisplayed(){
        return this.driver.findElement(managerIdText).isDisplayed();
    }

    public String getAlertMessageText() {
        return this.driver.switchTo().alert().getText();
    }


}
