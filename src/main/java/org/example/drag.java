package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class drag {

    public void dragdrop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Browser Drivers/chromedriver.exe");

        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("C:\\Users\\kapoo\\IdeaProjects\\SeleniumT\\src\\main\\resources\\drag.html");
        driver.manage().window().maximize();

        WebElement drag = driver.findElement(By.id("student1"));
        WebElement drop = driver.findElement(By.id("selected_students"));

        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).build().perform();

        Thread.sleep(6000); // just to see the effect
        System.out.println("Drag and Drop Successfully done");
        driver.quit();
    }
}
