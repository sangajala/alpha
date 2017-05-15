package alpha;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sriramangajala on 14/05/17.
 */
public class Gmail {

    private WebDriver driver;

    @Test
    public void openGmailPage(){
        System.setProperty("driver.chrome.driver","chromedriver");

        driver = new ChromeDriver();

        driver.get("http://bbc.com");

    }
}
