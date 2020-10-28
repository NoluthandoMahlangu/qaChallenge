package utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class seleniumFunctions {

    protected  static WebDriver driver;
    public JavascriptExecutor jExecutor;
    public WebDriverWait driverWait;
    public DesiredCapabilities cap = DesiredCapabilities.phantomjs();

    public WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
    public ExtentReports setExtentProperties(String reportname){
        ExtentReports extent = new ExtentReports(System.getProperty("user.dir") + "/guiReports/" + reportname + ".html", true);
//        extent.addSystemInfo("Environment", Environment);
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

        return extent;
    }

    // Take a screenshot
    public static void TakeApplicationScreenShot() throws Throwable {

        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("C:/Automation_Pictures/Screenshot" + ts + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    // Wait For a page to Load.

    /*public void WaitForLoad(WebDriver driver){
        ExpectedCondition<Boolean> pageLoadCondition = new

                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }*/

    /*
     * this sets up the the web driver for testNG multi-platform run takes only the
     * browser name and then sets up the web driver for the specified driver
     *
     */
    /*
     * this sets up the the web driver for testNG multi-platform run takes only the
     * browser name and then sets up the web driver for the specified driver
     *
     */
    public WebDriver setupWebDriver(String browserName) {
        String baseDir = System.getProperty("user.dir");
        String macDriverLocation = "\\Driver\\Mac\\";
        String linuxDriverLocation = "\\Driver\\Linux\\";
        String windowsDriverLocation = "\\src\\Driver\\Windows\\";
        // String windowsDriverLocation = "\\test\\Driver\\Windows\\";

        System.out.println("Browser name : " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = null;

            if (this.getOsName().equalsIgnoreCase("Windows")) {
                chromeDriverPath = windowsDriverLocation + "chromedriver.exe";
            } else if (this.getOsName().equalsIgnoreCase("Mac OS")) {
                chromeDriverPath = macDriverLocation + "chromedriver";
            } else if (this.getOsName().equalsIgnoreCase("Linux")) {
                chromeDriverPath = linuxDriverLocation + "chromedriver";
            }

            System.out.println("This is the chrome driver path is :::: " + chromeDriverPath);

            String absoluteChromeDriverPath = baseDir+chromeDriverPath;
            System.out.println("This is the chrome driver real path is :::: " + absoluteChromeDriverPath);

            System.setProperty("webdriver.chrome.driver", absoluteChromeDriverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("no-sandbox");
            options.setExperimentalOption("useAutomationExtension", false);
            return new ChromeDriver(options);

            // driver = new ChromeDriver(cOptions);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String firefoxDriverPath = null;
            System.out.println("Firefox ?: " + browserName);
            if (this.getOsName().equalsIgnoreCase("Windows")) {
                firefoxDriverPath = windowsDriverLocation + "geckodriver.exe";
            } else if (this.getOsName().equalsIgnoreCase("Mac OS")) {
                firefoxDriverPath = macDriverLocation + "geckodriver";
            } else if (this.getOsName().equalsIgnoreCase("Linux")) {
                firefoxDriverPath = linuxDriverLocation + "geckodriver";
            }
            System.out.println("This is the firefox driver path is :::: " + firefoxDriverPath);

            String absoluteFirefoxDriverPath = baseDir+firefoxDriverPath;
            System.out.println("This is the chrome driver real path is :::: " + absoluteFirefoxDriverPath);

            System.setProperty("webdriver.gecko.driver", absoluteFirefoxDriverPath);
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            String ieDriverPath = null;

            if (this.getOsName().equalsIgnoreCase("Windows")) {
                ieDriverPath = windowsDriverLocation + "IEDriverServer.exe";
            } else if (this.getOsName().equalsIgnoreCase("Mac OS")) {
                ieDriverPath = macDriverLocation + "IEDriverServer";
            } else if (this.getOsName().equalsIgnoreCase("Linux")) {
                ieDriverPath = linuxDriverLocation + "IEDriverServer";
            }
            System.out.println("This is the chrome driver path is :::: " + ieDriverPath);

            String absoluteIeDriverPath = baseDir+ieDriverPath;
            System.out.println("This is the chrome driver real path is :::: " + absoluteIeDriverPath);

            System.setProperty("webdriver.ie.driver", absoluteIeDriverPath);
            driver = new InternetExplorerDriver();

        } else if (browserName.equalsIgnoreCase("grid")){  // GRID
            DesiredCapabilities cap = DesiredCapabilities.phantomjs();
            // Add
            //tLog.logInfo("Chrome called on Selenium Grid");
            cap.setCapability("platform", "LINUX");
            cap.setCapability("version", "59.0.3071.115");
            try {
                driver = new RemoteWebDriver(new URL("http://10.74.11.36:9010/wd/hub"),cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        try {
            jExecutor = (JavascriptExecutor) driver;
            driver.manage().window().maximize();
            driverWait = new WebDriverWait(driver, 5);
        } catch (Exception e) {
            System.out.println("The stack trace here happens when I try to maximize the screen");
            e.printStackTrace();
        }
        return driver;
    }
    public static String getConfigPropertyValue(String propertyFileName, String propertyName){
        String Value = null;
        try{
            FileInputStream fileIS = new FileInputStream(new File(propertyFileName));
            Properties prop =  new Properties();
            prop.load(fileIS);

            Value = prop.getProperty(propertyName);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        return  Value;
    }
    /**
     * Delay time in seconds to pause or hold for some page objects to load takes
     * only integer value of number of seconds to pause
     *
     */
    public void secondsDelay(int sec) {
        int timeinMilliSeconds;
        try {
            timeinMilliSeconds = sec * 1000;
            Thread.sleep(timeinMilliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get the os type that the code is running on takes no variable but returns the
     * os type such as: Windows, Mac OS, Linux
     *
     */

    public String getOsName() {
        String osType;
        String osName = "";

        osType = System.getProperty("os.name");

        if (osType.contains("Windows") || osType.contains("windows")) {
            osName = "Windows";
        } else if (osType.contains("Mac") || osType.contains("mac")) {
            osName = "Mac OS";
        } else if (osType.contains("Linux") || osType.contains("linux")) {
            osName = "Linux";
        }

        System.out.println("os Type is ::: " + osType + "found os Name ::: " + osName);

        return osName;
    }

    /*
     * this method takes screenshot at anytime it is called it returns the file name
     * of the screenshot taken
     *
     */
    public String takeScreenShot(String initFileName, WebDriver driver, ExtentTest logger) {
        String fileName = null;

        int rand = 0;
        try {
            fileName = initFileName + "_" + rand + ".png";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File outFile = new File("./guiReports/TestArtifacts/"+initFileName);
            FileUtils.copyFile(scrFile, outFile);
            String outFileToLog = "/guiReports/TestArtifacts/"+initFileName;
            System.out.println("Out File is"+outFileToLog);
            logger.log(LogStatus.INFO, logger.addScreenCapture(outFileToLog));

        } catch (IOException e) {
            logger.log(LogStatus.INFO, "Unable to log screenshot "+initFileName);
        }
        return fileName;
    }
    public void endReport(ExtentReports extent){
        extent.flush();
        extent.close();
        secondsDelay(10);
        driver.close();
    }

}
