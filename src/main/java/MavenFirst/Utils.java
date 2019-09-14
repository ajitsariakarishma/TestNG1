package MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Utils extends BasePage {

    public static void enterText(By by,String text){

        driver.findElement(by).sendKeys(text);

    }

     public static String getTextFromElement(By by){
         return driver.findElement(by).getText();

     }
     public static void clickElement(By by){
        driver.findElement(by).click();

     }
     public static void waitForelemntVisible(By by, long time){
         WebDriverWait wait = new WebDriverWait(driver,time);
         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

     }
    public static void waitForClikable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

     public static void forAlterPresent(long time){
         WebDriverWait wait  = new WebDriverWait(driver, time);
         wait.until(ExpectedConditions.alertIsPresent());

     }
     public static String randomDate(){
         SimpleDateFormat simpledateformat = new SimpleDateFormat("ddMMyyHHmmss");
         return simpledateformat.format(new Date());


     }


}
