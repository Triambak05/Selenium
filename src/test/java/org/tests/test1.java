package org.tests;

import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.Main;
import org.testng.*;
import org.example.excel;

import java.io.IOException;
import org.example.xPath;

public class test1 {

   public static void main(String[] arg) throws InterruptedException, IOException {


//        Main m = new Main();
//        m.locators();
//
//        drag d = new drag();
//        d.dragdrop();
//
//        multipleTabs mt = new multipleTabs();
//        mt.HandleTabs();

//       excel e = new excel();
//       e.excelSheet();
//       Thread.sleep(200);
//       e.seleniumExcel();

       xPath x = new xPath();
       x.xPathAxes();


   }
}
