package com.lg.hooks;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.lg.factory.DriverFactory;
import com.lg.context.TestContext;
import com.lg.utils.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        testContext.driver = driver;
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Screenshot(driver)).build());
        }
        driver.quit();
    }
}
