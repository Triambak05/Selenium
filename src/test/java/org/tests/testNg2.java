package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testNg2 {
    WebDriver driver;


    @Parameters({"browser", "url"})
    @BeforeClass
    public  void test(@Optional("chrome") String browser, @Optional("https://www.youtube.com")String url) throws InterruptedException {

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Launch Chrome!!");
            Thread.sleep(2000);
        }

        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Launch Firefox!!");
            Thread.sleep(2000);
        }
        else {
            System.out.println("Invalid browser name provided: " + browser + " is your default browser");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            Thread.sleep(2000);

        }

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(1000);
    }

    @Parameters({"expectedTitle"})
    @Test
    public void title(@Optional("YouTube") String expectedTitle){
        String title = driver.getTitle();
        System.out.println("Actual Page Title: "+ title);
        System.out.println("Expected Page Title: "+ expectedTitle);
        Assert.assertNotNull(title);
        Assert.assertTrue(title.contains(expectedTitle), "Title Verification failed: " + title);

    }

    @AfterClass
    public  void close() throws InterruptedException {
        if (driver != null){
            Thread.sleep(4000);
            driver.close();
        }
    }


}
