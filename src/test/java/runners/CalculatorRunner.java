package runners;

import io.cucumber.testng.CucumberOptions;
import cucumber.api.junit.Cucumber;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.PickleEventWrapper;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cucumber"},
        glue = {"stepdefs"},
        tags = {"@Android"},
        plugin = { "pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:target/cucumber-report/cucumber-html-report",
                "json:target/cucumber-report/cucumber.json",
                "pretty:target/cucumber-report/cucumber-pretty.txt",
                "usage:target/cucumber-report/cucumber-usage.json",
                "junit:target/cucumber-report/cucumber-results.xml" },
        monochrome = true
)

public class CalculatorRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}