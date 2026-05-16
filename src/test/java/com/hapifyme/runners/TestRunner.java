package com.hapifyme.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Test Runner Cucumber si JUnit

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue     = {"com.hapifyme.stepdefinitions",
                    "com.hapifyme.hooks"},
        plugin   = {
                "pretty",
                "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "junit:target/cucumber-reports/cucumber-report.xml"
        },
        monochrome  = true,
        dryRun      = false
)
public class TestRunner {
        // Această clasă rămâne goală!
        // Ea servește doar ca suport pentru adnotări.

}
