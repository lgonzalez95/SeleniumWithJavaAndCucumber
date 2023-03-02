package com.lg.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com/lg"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = "@Debug"
)
public class DefaultRunnerTest {
}