package Runner;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"src/test/java/features"},
        //tags = {"@Regression","@Sanity"},
        format = { "json:target/QAchallenge.json", "pretty",
                "html:target/QA_CHALLENGE" },
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }
         //, monochrome = true,
        // dryRun = true
)

public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {

        Reporter.loadXMLConfig("extent-config.xml");
    }


}
