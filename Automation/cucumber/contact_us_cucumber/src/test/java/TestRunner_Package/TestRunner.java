package TestRunner_Package;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/main/resources/Features/contactus.feature"},
                glue = "StepDef",
                tags = "@Contact_US_Scenario",
                plugin = {"pretty","html:target/report/contactus.html" }

        )
public class TestRunner extends AbstractTestNGCucumberTests {
}
