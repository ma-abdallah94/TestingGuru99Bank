package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigUtils;

public class LoginTest extends BaseTest {


    @Test
    public void enterValidUserAndValidPassword () {
        LoginPage loginPage = new LoginPage(driver);
        boolean weAreLoggedIn = loginPage.load()
                .login(ConfigUtils.getInstance().userId() , ConfigUtils.getInstance().password())
                .managerIdIsDisplayed();

        Assert.assertTrue(weAreLoggedIn);
        screenShotCapture("EnterValidUserAndValidPassword");
    }

    @Test
    public void enterInvalidUserAndValidPassword () {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult = loginPage.load()
                .login("AnyUser" , ConfigUtils.getInstance().password())
                .getAlertMessageText();

        Assert.assertEquals(actualResult ,"User or Password is not valid");

    }

    @Test
    public void enterValidUserAndInvalidPassword () {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult = loginPage.load()
                .login(ConfigUtils.getInstance().userId() , "passWo$rd")
                .getAlertMessageText();

        Assert.assertEquals(actualResult ,"User or Password is not valid");
    }

    @Test
    public void enterInvalidUserAndInvalidPassword () {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult = loginPage.load()
                .login("AnyInvalidUID" , "passWo$rd")
                .getAlertMessageText();

        Assert.assertEquals(actualResult ,"User or Password is not valid");

    }
}
