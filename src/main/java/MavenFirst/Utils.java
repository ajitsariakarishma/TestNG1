package MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Utils extends BasePage {
    //enter text at location
    public static void enterText(By by,String text){

        driver.findElement(by).sendKeys(text);

    }
     // get text from  location
     public static String getTextFromElement(By by){
         return driver.findElement(by).getText();

     }
     // click on web element
     public static void clickElement(By by){
        driver.findElement(by).click();

     }
     // wait for element to be visiable
     public static void waitForElementVisible(By by, long time){
         WebDriverWait wait = new WebDriverWait(driver,time);
         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

     }
     //wait for element to clickable
    public static void waitForClikable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
      //wait for alert to display
     public static void forAlterPresent(long time){
         WebDriverWait wait  = new WebDriverWait(driver, time);
         wait.until(ExpectedConditions.alertIsPresent());

     }
     //to generate unique number everytime it runs
     public static String randomDate(){
         SimpleDateFormat simpledateformat = new SimpleDateFormat("ddMMyyHHmmss");
         return simpledateformat.format(new Date());


     }
     //mouse hover movement
     public static void movedriverToWebElement(By by){
         Actions actions = new Actions(driver);

         //storing location of dropdown in webelement variable
         WebElement menuList = driver.findElement(by);
         actions.moveToElement(menuList).perform();

     }
     //launching chrome driver with pre requisites
    public static void launchChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\WebBrowser\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    //Handling dropdown by visible text
    public static void handlingDropdownByVisibleText(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }
    //handling dropdown by value
    public static void handlingDropdownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //handling dropdown by index number
    public static void handlingDropdownByIndex(By by, int index_num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index_num);
    }


}
