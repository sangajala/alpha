package alpha;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.internal.Streams;

public class Register {
    private ChromeDriver driver;
    private A a;
    private String email = "test12121@gmail.com";


    @Before//opening the driver
    public void setUp() throws Exception {
        //invoke the driver
        System.setProperty("web.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        a = new A();
        //open url
        driver.get("http://demo.nopcommerce.com/register");
        email = getRandomEmail();
        System.out.println(email);


     //   baseUrl = "http://demo.nopcommerce.com/";
        //set time out
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

//    @Test//actual test
    public void testRegister() throws Exception {
        driver.findElement(By.id("FirstName")).sendKeys("test");
        driver.findElement(By.id("LastName")).sendKeys("user");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("12345678");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("12345678");
        driver.findElement(By.id("register-button")).click();
        // Warning: assertTextPresent may require manual changes
        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Your registration completed[\\s\\S]*$"));
    }
    @Test
    public void loginPriya() {

        driver.get("http//:demo.nop.commerce.com");
        //click Login link
        driver.findElement(By.linkText("Log in")).click();
        //enter username
        driver.findElement(By.id("ghg")).sendKeys("Priya");
        //enter password
        driver.findElement(By.id("fgfg")).sendKeys("1235679");
        //click Login
        driver.findElement(By.xpath("fgg")).click();
        //storing tthe text from the body element
        String actualtext;
        actualtext=driver.findElement(By.xpath("//body")).getText();
        //compare the actual with expected
        String expected = "Welcome";
        assertEquals(actualtext,expected);
    }
    @Test
    public void testLogin() throws Exception {




        testRegister();

        driver.get("http://demo.nopcommerce.com/logout");
        driver.get("http://demo.nopcommerce.com/login");

        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("12345678");
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();

        assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
    }

    @Test
    public void testcasetoSearch(){
        driver.findElement(By.id("small-searchterms")).sendKeys("invalid search");
        driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/input[2]")).click();


        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();


        driver.findElement(By.linkText("Log in")).click();

        //77 = 73+74
    }

    @Test
    public void testLogin4() throws Exception {
        driver.get("http://demo.nopcommerce.com/login");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("test@test.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("12345678");
        driver.findElement(By.id("RememberMe")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();
        // Warning: assertTextPresent may require manual changes
//        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Login was unsuccessful\\.[\\s\\S]*$"));
    }

    @Test
    public void invalidLogin() {
        //open
        driver.get("http://demo.nopcommerce.com/login");
        //enter email
        driver.findElement(By.id("Email")).sendKeys("test@test.com");
        //enter password
        driver.findElement(By.id("Password")).sendKeys("12345");
        //click login button
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).click();
        //Asserting the actual with expecterd value;
        //store the actual value
        String actual = driver.findElement(By.cssSelector("BODY")).getText();
        //Expected value
        String expected_message = "Login was efdfunsuccessful";
        assertTrue(actual.contains(expected_message));
    }




    public String getRandomEmail()
    {
        Random random = new Random();
        return  random.nextInt()+"test@gmail.com";
    }


    @After//closing the driver
    public void tearDown() throws Exception {
        //close the driver
        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }

}
