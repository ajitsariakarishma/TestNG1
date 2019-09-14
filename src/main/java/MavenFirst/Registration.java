package MavenFirst;

import javafx.scene.input.DataFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static okhttp3.internal.http.HttpDate.format;
import static org.openqa.selenium.By.xpath;

public class Registration extends Utils {

    LoadProperty props = new LoadProperty();




        @BeforeMethod
        public void setup (){
            launchChromeDriver();
            driver.get(props.getProperty("url"));

        }

       @Test
        public void userShouldBeAbleToRegisterSuccesfully(){

        //click on 'Register' button
        //driver.findElement(By.xpath("//a[@class='ico-register']")).click();
          clickElement(By.xpath("//a[@class='ico-register']"));

        //enter firstname
        //driver.findElement(By.id("FirstName")).sendKeys("Venus");
           enterText(By.id("FirstName"),props.getProperty("Firstname"));


        //enter last name
        //driver.findElement(xpath("//input[@name='LastName']")).sendKeys("Patel");
           enterText(By.xpath("//input[@name='LastName']"),props.getProperty("Lastname"));

        //Eneterting DOB
          handlingDropdownByVisibleText(By.xpath("//select[@name='DateOfBirthDay']"),"5");
          handlingDropdownByValue(By.xpath("//select[@name='DateOfBirthMonth']"),"10");
          handlingDropdownByIndex(By.xpath("//select[@name='DateOfBirthYear']"),80);

        //enter email
        //driver.findElement(By.name("Email")).sendKeys("abc"+randomDate()+"@gmail.com");
           enterText(By.name("Email"),props.getProperty("email_start")+randomDate()+props.getProperty("email_end"));


        //enter password
        //driver.findElement(By.id("Password")).sendKeys("london26");
           enterText(By.id("Password"),props.getProperty("password"));

        //enter confirm password
        //driver.findElement(By.xpath("//input[@name=\'ConfirmPassword']")).sendKeys("london26");
           enterText(By.xpath("//input[@name=\'ConfirmPassword']"),props.getProperty("password"));

        //click on register button
        //driver.findElement(By.xpath("//input[@type='submit' and @name='register-button']")).click();
           clickElement(By.xpath("//input[@type='submit' and @name='register-button']"));

        //storing value of actual in a string variable
           // String actual_msg= driver.findElement(By.className("result")).getText();
           String actual_msg = getTextFromElement(By.className("result"));
        String expected_msg = "Your registration completed";
        System.out.println("Actual Message is : "+actual_msg);

        //comparing actual message with expected message
        Assert.assertEquals(actual_msg,expected_msg);

    }

    @Test
    public void emailFriend()  {

        userShouldBeAbleToRegisterSuccesfully();

        //click on nop commerce icon for opening homepage
       //driver.findElement(xpath("//img[@alt='nopCommerce demo store']")).click();
        clickElement(By.xpath("//img[@alt='nopCommerce demo store']"));

        //click on imac pro image
       //driver.findElement(xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']")).click();
        clickElement(By.xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']"));

        //click on email friend
        //driver.findElement(xpath("//input[@value='Email a friend']")).click();
        clickElement(By.xpath("//input[@value='Email a friend']"));

        //enter email id of friend
        //driver.findElement(xpath("//input[@class='friend-email']")).sendKeys("brightvibrant@yahoo.com");
        enterText(By.xpath("//input[@class='friend-email']"),props.getProperty("friend_email"));


        //enter message
        //driver.findElement(By.id("PersonalMessage")).sendKeys("This is good, try");
        enterText(By.id("PersonalMessage"),props.getProperty("email_msg"));

        //click on send email button
        //driver.findElement(xpath("//input[@value='Send email']")).click();
        clickElement(By.xpath("//input[@value='Send email']"));

        String expectedConfirmMessage="Your message has been sent.";
        String actualmessage=getTextFromElement(By.xpath("//div[@class='result']"));
                //driver.findElement(xpath("//div[@class='result']")).getText();
        System.out.println("Acutal confirmation message is : "+actualmessage);
        Assert.assertEquals(actualmessage,expectedConfirmMessage);//comparing actual result with expected.

    }
    @Test
    public void userShouldBeAbleToNavigateToCameraandPhotoPage(){
       //creating instance of action class for mouse hover.
        //(xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        movedriverToWebElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        //selecting and clicking camera and photo subcategory.
        // driver.findElement(xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));


        //getting and storing actual display message.
        String actual_msg = getTextFromElement(By.xpath("//h1"));
                //driver.findElement(xpath("//h1")).getText();

        String expected_msg = "Camera & photo";
        System.out.println("Actual tittle displayed is: "+actual_msg);

        //asserting the validity.
        Assert.assertEquals(actual_msg, expected_msg);
    }
    @Test
    public void userShouldBeAbleToFilterJewelleryByPrice() {
        String ans;

        //Clicking on Jewellery link on the homepage.
        //driver.findElement(xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]")).click();
        clickElement(By.xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]"));

        //Clicking on the filter attribute of range $700-$3000
        //driver.findElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']")).click();
        clickElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']"));

        //getting relevant text according to the filter selected.
        String price = getTextFromElement(By.xpath("//span[@class='price actual-price']"));
                //driver.findElement(xpath("//span[@class='price actual-price']")).getText();
        System.out.println(price);


        //eliminating junk characters and converting string to integer value.
        price = price.substring(0, 6);
        price = price.replaceAll("[^0-9]", "");
        int x = Integer.parseInt(price);
        //checking the filter function
        if (x >= 700 && x <= 3000) {
            ans = "PASSED";
            System.out.println("Your test has " + ans);
        } else {

            ans = "FAILED";
            System.out.println("Your test has " + ans);

        }
        //checking user is navigated to jewllery page
        String pageTitle=getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
                //driver.findElement(xpath("//h1[contains(text(),'Jewelry')]")).getText();
        String actual_title="Jewelry";
        System.out.println("you are navigated to :"+actual_title+" page." );
        Assert.assertEquals(pageTitle,actual_title);
    }
        @Test
        public void userShouldBeAbleToAddTheProductsToTheShoppingCart() throws InterruptedException {

            //clicking on books link
            //driver.findElement(xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]")).click();
            clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));

            //Clicking on a book
            //driver.findElement(xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']")).click();
            clickElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']"));

            //adding a book to the cart
           //driver.findElement(By.cssSelector("#add-to-cart-button-37")).click();
            clickElement(By.cssSelector("#add-to-cart-button-37"));

            //clicking on books link
            //driver.findElement().click();
            clickElement(By.xpath("//span[contains(text(),'Books')]"));

            //selecting another book to add to cart
            // driver.findElement(By.cssSelector("img[title$='Prejudice']")).click();
            clickElement(By.cssSelector("img[title$='Prejudice']"));

            //adding to cart
            // driver.findElement(By.cssSelector("#add-to-cart-button-39")).click();
            clickElement(By.cssSelector("#add-to-cart-button-39"));

            //instructing browser to wait
            Thread.sleep(5000);

            //clicking on shopping cart label to view the products added
            //driver.findElement(xpath("//span[@class='cart-label']")).click();
            clickElement(By.xpath("//span[@class='cart-label']"));

            //(xpath("//span[@class='cart-label']"));
            movedriverToWebElement(By.xpath("//span[@class='cart-label']"));


           //storing and getting string value in a variable
            String qty = getTextFromElement(By.xpath("//span[@class='cart-qty']"));
                    //driver.findElement(xpath("//span[@class='cart-qty']")).getText();
            System.out.println("actual qty ordered: "+qty);
            String expected_qty="(2)";
            Assert.assertEquals(qty, expected_qty);


        }


   @AfterMethod
    public void teardownr(){

    driver.quit();


    }

    }

