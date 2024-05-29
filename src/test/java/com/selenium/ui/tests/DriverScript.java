package com.selenium.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverScript {



    public WebDriver getDriver(){

      return WebDriverManager.chromedriver().create();

    }


}
