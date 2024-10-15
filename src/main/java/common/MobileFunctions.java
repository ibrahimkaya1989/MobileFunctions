package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;
import pages.NumbersPage;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileFunctions implements MainSteps {

    public AppiumDriver<MobileElement> driver;
    public BasePage page;

    public void initializeDriver(String device) throws MalformedURLException {

        if(device.equalsIgnoreCase("Android")) {
            DesiredCapabilities cap = new DesiredCapabilities();

            // Smartphone Infos
            cap.setCapability("deviceName", "R6CT400PWGR");
            cap.setCapability("udid", "R6CT400PWGR");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "14");

            cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability("noReset", true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");  // http://127.0.0.1:4723/wd/hub

            driver = new AppiumDriver<>(url, cap);
        }
    }

    public void seePage(String pageName) {
        switch (pageName) {
            case "Login": page = new LoginPage(); break;
            case "Numbers": page = new NumbersPage(); break;
            default: break;
        }
    }

    public WebElement waitElement(String element, int timeout) throws InterruptedException {
        WebElement object;
        for (int i = 0; i < timeout; i++) {

            object = findElement(element, 0);
            if (object != null) {
                Thread.sleep(2000);
                return object;
            } else {
                Thread.sleep(2000);
            }
        }
        Assert.fail("Waiting element is not found!");
        return null;
    }

    public WebElement findElement(String element, int index) {
        try {
            WebElement object;

            By elem = page.pageElements.get(element);

            if (elem == null) {
                elem = page.commonElements.get(element);
            }
            object = driver.findElements(elem).get(index);
            System.out.println("Object found : " + element + " # " + object.toString());
            return object;
        } catch (Exception e) {
            Assert.fail("Element is not found! # " + e);
            return null;
        }
    }

    public WebElement waitElementIndex(String element, int index, int timeout) throws InterruptedException {
        WebElement object;
        for (int i = 0; i < timeout; i++) {

            object = findElement(element, index);
            if (object != null) {
                Thread.sleep(2000);
                return object;
            } else {
                Thread.sleep(2000);
            }
        }
        Assert.fail("Waiting element is not found!");
        return null;
    }

    public void clickElement(String element, int index) throws InterruptedException {
        WebElement object = waitElement(element, 30);

        if (object != null) {
            findElement(element, index).click();
            System.out.println("Clicked on object--> " + element + " # " + object);
        } else {
            System.out.println("Could not click on object--> " + element + " # " + object);
        }
    }

    public void enterText(String text, String element) {
        WebElement object;
        object = findElement(element, 0);

        if (object != null) {
            object.sendKeys(text);
            System.out.println("The text has been entered.");
        }
    }

    public void clickKeyboard(String key) {
        Actions action = new Actions(driver);
        switch (key) {
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "TAB":
                action.sendKeys(Keys.TAB).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "PAGE_DOWN":
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "PAGE_UP":
                action.sendKeys(Keys.PAGE_UP).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "ESC":
                action.sendKeys(Keys.ESCAPE).build().perform();
                System.out.println(key + " clicked.");
                break;
            case "1":
                action.sendKeys(Keys.NUMPAD1).build().perform();
                System.out.println(key + " clicked.");
                break;
            default:
                break;
        }
    }

    public void clickKeyboardWithElement(String key, String element) {
        WebElement object = findElement(element, 0);
        if (object != null) {
            switch (key) {
                case "ENTER":
                    object.sendKeys(Keys.ENTER);
                    break;
                case "TAB":
                    object.sendKeys(Keys.TAB);
                    break;
                case "PAGE_DOWN":
                    object.sendKeys(Keys.PAGE_DOWN);
                    break;
                case "PAGE_UP":
                    object.sendKeys(Keys.PAGE_UP);
                    break;
                case "ESC":
                    object.sendKeys(Keys.ESCAPE);
                    break;
                default:
                    break;
            }
        }
    }

    public void allureReport(String result, String message, boolean ssFlag) {
        try {
            if (ssFlag) {
                Allure.addAttachment("Screenshot : " + message, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            }
            if (result.equalsIgnoreCase("PASS")) {
                Allure.step(message);
            } else if (result.equalsIgnoreCase("INFO")) {
                Allure.step(message);
            } else if (result.equalsIgnoreCase("FAIL")) {
                Allure.step(message);
                Assert.fail(message);
            } else {
                Allure.step(message);
            }

        } catch (Exception ignore) {
            // Do nothing...
        }

    }
}
