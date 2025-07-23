package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step", "hooks"},
        plugin = {
                "pretty",
                "html:target/web/cucumber-html-report.html",
                "json:target/web/cucumber-report.json"
        },
        monochrome = true

)
public class TestRunner {
}
