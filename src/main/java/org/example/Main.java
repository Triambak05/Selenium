package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public void locators() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Browser Drivers/chromedriver.exe");

        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("C:\\Users\\kapoo\\IdeaProjects\\SeleniumT\\src\\main\\resources\\index.html");
        driver.manage().window().maximize();


        driver.findElement(By.id("signup_choice_btn")).click();

        WebElement name = driver.findElement(By.id("student_name"));
        name.sendKeys("Triambak Kapoor");

        Thread.sleep(1000);

        WebElement email = driver.findElement(By.name("student_email"));
        email.sendKeys("triambak.official09@gmail.com");

        Thread.sleep(1000);

        WebElement contact = driver.findElement(By.className("contact"));
        contact.sendKeys("9797930950");

        Thread.sleep(1000);

        WebElement std_class = driver.findElement((By.id("student_class")));
        std_class.click();
        Select selectClass = new Select(std_class);

        selectClass.selectByIndex(10);

        Thread.sleep(1000);

        WebElement tag = driver.findElement(By.tagName("input"));
        System.out.println("Tag Name: " + tag.getAttribute("id"));

        Thread.sleep(1000);

        WebElement password = driver.findElement((By.cssSelector("input#student_password")));
        password.sendKeys("Kapoo09#");

        Thread.sleep(1000);

//        WebElement linkText = driver.findElement(By.linkText("Create Account"));
//        System.out.println("Link Text:" + linkText.getText());
//
//        Thread.sleep(1000);

        WebElement  create = driver.findElement(By.xpath("//button[@id='signup_submit_btn']"));
        create.click();

        Thread.sleep(1000);
        System.out.println("Test Successfully Completed");

        Thread.sleep(4000);
        driver.close();

    }
}

