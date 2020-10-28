package ActionsFlow;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.pageObjects;
import utils.seleniumFunctions;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class checkoutproductFlow extends seleniumFunctions {
    public ExtentTest logger;
    private ExtentReports extent;

    @Override
    public WebDriver getDriver() {
        return super.getDriver();
    }

    public void urlInit(String username, String password) throws Throwable{
        String browser = getConfigPropertyValue("./Framework.properties", "driver");
        driver = setupWebDriver(browser);
        driver.get("https://www.saucedemo.coma");
        driver.manage().window().maximize();
        Thread.sleep(5);
        TakeApplicationScreenShot();
    }

    public static void Logon(String username, String password) throws Throwable{
        driver.findElement(By.xpath(pageObjects.txt_username)).sendKeys(username);
        driver.findElement(By.xpath(pageObjects.txt_password)).sendKeys(password);
        driver.findElement(By.xpath(pageObjects.btn_login)).click();
        Thread.sleep(5);
        TakeApplicationScreenShot();
    }

    public static void AddProducts() throws Throwable{

        driver.findElement(By.xpath(pageObjects.btn_addprod1)).click();
        driver.findElement(By.xpath(pageObjects.btn_addprod2)).click();
    }

    public static void verifyValueAdded() {
        driver.findElement(By.cssSelector("path")).click();
        try {
            assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath(pageObjects.btn_verifyPro1)).getText());
        } catch (Error e) {
            e.getMessage();
        }
        try {
            assertEquals("Sauce Labs Onesie", driver.findElement(By.xpath(pageObjects.btn_verifyPro2)).getText());
        } catch (Error e) {
            e.getMessage();
        }

        try {
            Thread.sleep(50);
            driver.findElement(By.cssSelector(pageObjects.btn_checkoutI)).click();
            driver.findElement(By.linkText(pageObjects.btn_checkoutII)).click();
        }catch (Exception e){
            e.getMessage();
        }


    }

    public static void enterDetails(String name, String lastname, String postalAddress){
      driver.findElement(By.id(pageObjects.txt_firstname)).sendKeys(name);
      driver.findElement(By.id(pageObjects.txt_lastname)).sendKeys(lastname);
      driver.findElement(By.id(pageObjects.txt_postalcode)).sendKeys(postalAddress);
      driver.findElement(By.xpath(pageObjects.btn_continue)).click();

     }

      public static void assertAndConfirmsOrder() throws Throwable {
          Thread.sleep(2000);
          JavascriptExecutor jse = (JavascriptExecutor) driver;
          jse.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(By.xpath(pageObjects.lbl_assertAmount)));
          assertEquals("Total: $41.02", driver.findElement(By.xpath(pageObjects.lbl_assertAmount)).getText());

          TakeApplicationScreenShot();
      }

      public static void finishOrder(){

          driver.findElement(By.linkText(pageObjects.btn_finish)).click();

      }

      public static void finaliseOrder() throws Throwable{

          Thread.sleep(2000);
          JavascriptExecutor jse = (JavascriptExecutor) driver;
          jse.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(By.xpath(pageObjects.lbl_assertOrder)));
          TakeApplicationScreenShot();
          try {
              assertEquals("THANK YOU FOR YOUR ORDER", driver.findElement(By.xpath(pageObjects.lbl_assertOrder)).getText());
          } catch (Error e) {
              e.getMessage();
          }
      }
}
