package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPath {

    public void xPathAxes(){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("C:\\Users\\kapoo\\IdeaProjects\\SeleniumT\\src\\main\\resources\\login.html");

        WebElement book = driver.findElement(By.xpath("//td[text()= 'Selenium Grid']/preceding-sibling::td/a"));
        System.out.println(driver.getTitle());
        book.click();

    }
}
