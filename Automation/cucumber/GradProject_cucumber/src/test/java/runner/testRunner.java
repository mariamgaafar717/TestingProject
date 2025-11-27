package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features/Scroll.feature" ,
        glue = "Stepsdeff" ,
        tags = "@withArrow" ,
        plugin = {"pretty" , "html:target/Reports/Scroll.html"}
)
public class testRunner extends AbstractTestNGCucumberTests {
}
