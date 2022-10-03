package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver ;

    public WebDriver driverInitializer(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver ;
        }

    @BeforeMethod
    public void setup() {
        driver =new BaseTest().driverInitializer();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    public void screenShotCapture(String testCaseName){

        File screenshotDest = new File("Screenshots"+ File.separator + testCaseName+".png");
        takeScreenshot(screenshotDest);
    }


    public void takeScreenshot(File screenshotDest){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file , screenshotDest);
        } catch (IOException e) {
            throw new RuntimeException("Something Went Wrong While Taking Screenshot");
        }
    }
}
