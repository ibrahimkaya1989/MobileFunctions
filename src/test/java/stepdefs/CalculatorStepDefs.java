package stepdefs;

import constants.TestStepResults;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.BasePage;
import common.MobileFunctions;

import java.net.MalformedURLException;

public class CalculatorStepDefs extends BasePage {

    MobileFunctions mobileFunctions;

    @Before
    public void beforeScenario() {
        System.out.println("-------------------- Before Scenario --------------------");
    }

    @After
    public void afterScenario() {
        System.out.println("-------------------- After Scenario --------------------");

        waitForNSeconds(5);
        mobileFunctions.driver.quit();
    }

    @When("^I initialize (Android|iOS) device$")
    public void initializeDriver(String device) throws MalformedURLException {
        mobileFunctions = new MobileFunctions();
        mobileFunctions.initializeDriver(device);
    }

    @When("^I see (.*) page$")
    public void seePage(String page) {
        mobileFunctions.seePage(page);
        System.out.println("Page shown up " + page);
    }

    @When("^I wait (.*) element (\\d+) seconds$")
    public void waitElement(String element, int timeout) throws InterruptedException {
        mobileFunctions.waitElement(element, timeout);
        System.out.println("Clicked clear button");
    }

    @When("^(?:I )?wait element: (.*) of index: (\\d+) for (\\d+) seconds$")
    public void waitElement(String element, int index, int timeout) throws InterruptedException {
        mobileFunctions.waitElementIndex(element, index-1, timeout);
    }

    @When("^(?:I )?click element: (.*) index: (\\d+)$")
    public void clickElement(String element, int index) {
        WebElement object = mobileFunctions.findElement(element,index - 1 );

        if (object != null) {
            object.click();
            System.out.println("Clicked on object-->" + element);
            //mobileFunctions.allureReport(TestStepResults.PASS, "Clicked on object-->" + element, true );
        } else {
            System.out.println("Could not click on object-->" + element);
        }
    }

    @When("^(?:I )?wait for (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @When("^I click \"([^\"]*)\" keyboard button$")
    public void clickKeyboard(String key) {
        mobileFunctions.clickKeyboard(key);
    }

    @When("^I do click \"([^\"]*)\" keyboard button at \"([^\"]*)\" element$")
    public void clickKeyboardWithElement(String key, String element) {
        mobileFunctions.clickKeyboardWithElement(key, element);
    }

    @When("^I send text \"([^\"]*)\" to \"([^\"]*)\" element$")
    public void sendText(String value, String element) {
        mobileFunctions.enterText(value, element);
    }

    @When("^(?:I )?clean (.*) then I enter \"([^\"]*)\" text$")
    public void cleanField(String element, String text) throws InterruptedException {
        By elem = mobileFunctions.page.pageElements.get(element);
        mobileFunctions.driver.findElement(elem).clear();
        waitForNSeconds(2);
        enterText(text, element);
    }

    @When("^I enter \"([^\"]*)\" text to (.*) text area$")
    public void enterText(String text, String element) throws InterruptedException {
        mouseHover(element);
        WebElement object;
        object = mobileFunctions.findElement(element,0);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    @When("^(?:I )?focus (.*) element$")
    public void mouseHover(String element) throws InterruptedException {
        Actions actions = new Actions(mobileFunctions.driver);
        WebElement elem = mobileFunctions.waitElement(element, 5);
        actions.moveToElement(elem).perform();
        Thread.sleep(2000);
    }

    @When("^(?:If)? exist (.*) element, tap on it $")
    public void ifExist(String elementKey) throws InterruptedException {
        WebElement element = mobileFunctions.waitElement(elementKey, 5);

        try {
            if (element != null) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
