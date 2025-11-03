package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excel {

    public void excelSheet() throws IOException {
        FileInputStream f = new FileInputStream("C:\\Users\\kapoo\\IdeaProjects\\SeleniumT\\src\\main\\resources\\SeleniumDummyData.xlsx");

        Workbook wb = new XSSFWorkbook(f);
        Sheet s = wb.getSheetAt(0);

        int rCount = s.getPhysicalNumberOfRows();

        for(int i = 1; i < rCount; i++){
            Row row = s.getRow(i);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String search = row.getCell(2).getStringCellValue();
            String expectedRes = row.getCell(3).getStringCellValue();

            System.out.println(" | "+ username + " | " + password + " | " + search + " | " + expectedRes + " | ");
        }

        wb.close();
        f.close();
    }

    public void seleniumExcel() throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.manage().window().maximize();

        FileInputStream f = new FileInputStream("C:\\Users\\kapoo\\IdeaProjects\\SeleniumT\\src\\main\\resources\\SeleniumDummyData.xlsx");
        Workbook wb = new XSSFWorkbook(f);
        Sheet s = wb.getSheetAt(0);

        int rc = s.getPhysicalNumberOfRows();

        for(int i = 1; i <rc; i++){
            Row row = s.getRow(i);

            String search = row.getCell(2).getStringCellValue();
            String expectedRes = row.getCell(3).getStringCellValue();

            driver.get("https://ww.google.com");

            WebElement searching = driver.findElement(By.name("q"));
            searching.sendKeys(search);
            searching.submit();
            Thread.sleep(1000);

            System.out.println("searched: " + search);
            System.out.println("Expected: " + expectedRes);
        }

        wb.close();
        Thread.sleep(2000);
        driver.close();

    }
}
