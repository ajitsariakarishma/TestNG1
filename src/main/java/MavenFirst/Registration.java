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

public class Registration {
    protected static WebDriver driver;

    public String generateEmail(String startValue){

        String email= startValue.concat(new Date().toString().replaceAll(" ","").replaceAll(":",""));
        return email;

    }
       public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }





        @BeforeMethod
        public void setup (){
            System.setProperty("webdriver.chrome.driver","src\\main\\java\\Resources\\WebBrowser\\chromedriver.exe");

            //open the browser
            driver = new ChromeDriver();

            //maximise the browser window screen
            driver.manage().window().fullscreen();

            //set implicity wait for driver object
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

       @Test
        public void registrationNopCommerce(){
        //open the website
        driver.get("https://demo.nopcommerce.com");

        //click on 'Register' button

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Venus");

        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Patel");

        //enter email
        driver.findElement(By.name("Email")).sendKeys(generateEmail("test")+"@gmail.com");

        //enter password
        driver.findElement(By.id("Password")).sendKeys("london26");

        //enter confirm password
        driver.findElement(By.xpath("//input[@name=\'ConfirmPassword']")).sendKeys("london26");

        //click on register button
        driver.findElement(By.xpath("//input[@type='submit' and @name='register-button']")).click();

        //storing value of actual in a string variable
        String actual_msg= driver.findElement(By.className("result")).getText();
        String expected_msg = "Your registration completed";
        System.out.println("Actual Message is : "+actual_msg);

        //comparing actual message with expected message
        Assert.assertEquals(actual_msg,expected_msg);




    }

    @Test
    public void emailFriend() throws InterruptedException {

        registrationNopCommerce();
        //click on nop commerce icon for opening homepage
        driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();

        //click on imac pro image
        driver.findElement(By.xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']")).click();

        //click on email friend
        driver.findElement(By.xpath("//input[@value='Email a friend']")).click();

        //enter email id of friend
        driver.findElement(By.xpath("//input[@class='friend-email']")).sendKeys("brightvibrant@yahoo.com");

        //enter message
        driver.findElement(By.id("PersonalMessage")).sendKeys("This is good, try");

        //click on send email button
        driver.findElement(By.xpath("//input[@value='Send email']")).click();

        String expectedconfirmmessage="Your message has been sent.";
        String actualmessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println("Acutal confirmation message is : "+actualmessage);
        Assert.assertEquals(actualmessage,expectedconfirmmessage);//comparing actual result with expected.

    }
    @Test
    public void userShouldBeAbleToNavigateToCameraandPhotoPage(){
        //to enter url
        driver.get("https://demo.nopcommerce.com/");

        //creating instance of action class for mouse hover.
        Actions actions = new Actions(driver);

        //storing location of dropdown in webelement variable
        WebElement electronicsMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        actions.moveToElement(electronicsMenu).perform();

        //selecting and clicking camera and photo subcategory.
        WebElement selectElectronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        selectElectronics.click();

        //getting and storing actual display message.
        String actual_msg = driver.findElement(By.xpath("//h1")).getText();
        String expected_msg = "Camera & photo";
        System.out.println("Actual tittle displayed is: "+actual_msg);

        //assertubg the validity.
        Assert.assertEquals(actual_msg, expected_msg);
    }
    @Test
    public void userShouldBeAbleToFilterJewelleryByPrice() {
        String ans;

        driver.get("https://demo.nopcommerce.com/");

        //Clicking on Jewellery link on the homepage.
        driver.findElement(By.xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]")).click();

        //Clicking on the filter attribute of range $700-$3000
        driver.findElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']")).click();

        //getting relevant text according to the filter selected.
        String price = driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();
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
        String pageTitle=driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]")).getText();
        String actual_title="Jewelry";
        System.out.println("you are navigated to :"+actual_title+" page." );
        Assert.assertEquals(pageTitle,actual_title);
    }
        @Test
        public void userShouldBeAbleToAddTheProductsToTheShoppingCart() throws InterruptedException {
            driver.get("https://demo.nopcommerce.com/");

            //clicking on books link
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]")).click();
            //Clicking on a book
            driver.findElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']")).click();
            //adding a book to the cart
            driver.findElement(By.cssSelector("#add-to-cart-button-37")).click();
            //clicking on books link
            driver.findElement(By.xpath("//span[contains(text(),'Books')]")).click();
            //selecting another book to add to cart
            driver.findElement(By.cssSelector("img[title$='Prejudice']")).click();
            //adding to cart
            driver.findElement(By.cssSelector("#add-to-cart-button-39")).click();
            //instructing browser to wait
            Thread.sleep(5000);
            //clicking on shopping cart lable to view the products addied
            driver.findElement(By.xpath("//span[@class='cart-label']")).click();
            //creating instance of Action class
            Actions actions = new Actions(driver);
            //storing webelement in a variable
            WebElement shoppincart=driver.findElement(By.xpath("//span[@class='cart-label']"));
            actions.moveToElement(shoppincart).perform();
           //storing and getting string value in a variable
            String qty = driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
            System.out.println("actual qty ordered: "+qty);
            String expected_qty="(2)";
            Assert.assertEquals(qty, expected_qty);


        }


    @AfterMethod
    public void teardownr(){

    driver.quit();


    }

    }

