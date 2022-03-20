package common;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.MalformedURLException;

public interface MainSteps {

    public void initializeDriver(String browser) throws MalformedURLException;

    public void seePage(String page);

    public WebElement findElement(String element,int index);

    public WebElement waitElement(String element, int timeout) throws InterruptedException, IOException;

    public WebElement waitElementIndex( String element, int index, int timeout) throws InterruptedException, IOException;

    public void clickElement(String element, int index) throws InterruptedException;

    public void enterText(String text, String element);

    public void clickKeyboard(String key);

    public void clickKeyboardWithElement(String key, String element);
}
