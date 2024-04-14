package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\features"
        ,glue = "stepDefinition"
        ,plugin = {
                "pretty"
               ,"me.jvt.cucumber.report.PrettyReports:target/cucumber"
}
)
public class testRunner01 {
}
