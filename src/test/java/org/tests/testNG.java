package org.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNG {
    WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void open(){
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertNotNull(title);
        Assert.assertTrue(title.contains("Google"));
    }

    @AfterClass
    public void close(){
        if (driver != null){
            driver.close();
        }
    }
}
