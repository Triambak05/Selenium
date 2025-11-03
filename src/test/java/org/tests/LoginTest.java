package org.tests;

import org.apache.logging.log4j.LogManager;




import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    static Logger logger = LogManager.getLogger(LoginTest.class);

    public static void logs(){

        logger.info("this is info log");
        logger.warn("this is a warning");
        logger.error("this is error");
    }

}
