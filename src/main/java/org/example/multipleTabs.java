package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class multipleTabs {

    public void HandleTabs() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Browser Drivers/chromedriver.exe");

        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.name("p"));
        search.sendKeys("W3 Schools selenium");
        search.submit();
        Thread.sleep(1000);

        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://www.youtube.com");
        Thread.sleep(1000);

        WebElement ysearch = driver.findElement(By.name("search_query"));
        ysearch.sendKeys("selenium basics");
        ysearch.submit();
        Thread.sleep(1000);

        System.out.println("store in list");
        List<String> tabs = driver.getWindowHandles().stream().toList();
        driver.switchTo().window((tabs.getFirst()));
        System.out.println("Switch to Yahoo");
        Thread.sleep(1000);
        System.out.println("Title yahoo: "+ driver.getTitle());

        driver.switchTo().window((tabs.get(2)));
        System.out.println("Switch to Youtube");
        Thread.sleep(1000);
        System.out.println("Title Youtube: "+ driver.getTitle());

        System.out.println("Size: "+ tabs.size());

        Thread.sleep(5000);
        driver.close();




    }
}
