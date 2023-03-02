package com.lg.hooks;


import com.lg.factory.DriverFactory;
import com.lg.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
   private WebDriver driver;
   private final TestContext testContext;

   public Hooks(TestContext testContext){
       this.testContext = testContext;
   }

   @Before
    public void before(){
       driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
       testContext.driver = driver;
   }

   @After
    public void after(){
       driver.quit();
   }
}
