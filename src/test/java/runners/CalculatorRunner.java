package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleWrapper;

import io.qameta.allure.Attachment;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cucumber"},
        glue = {"stepdefs"},
        tags = "@Android",
        plugin = { "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-report/cucumber-html-report.html",
                "json:target/cucumber-report/cucumber.json",
                "pretty:target/cucumber-report/cucumber-pretty.txt",
                "usage:target/cucumber-report/cucumber-usage.json",
                "junit:target/cucumber-report/cucumber-results.xml" },
        monochrome = true,
        dryRun = true,
        publish = true
)

public class CalculatorRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeTest
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner( this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver oDriver) {
        return ((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES);
    }

    @DataProvider
    public Object[][] features() { return testNGCucumberRunner.provideScenarios(); }

    @AfterTest(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}