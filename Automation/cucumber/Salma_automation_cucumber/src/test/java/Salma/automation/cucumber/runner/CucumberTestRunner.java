package Salma.automation.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Salma.automation.cucumber.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests { }
