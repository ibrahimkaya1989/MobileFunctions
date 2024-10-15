package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class LoginPage extends BasePage {

    public Hashtable<String, By> loginElements;

    public LoginPage(){
        super();
        this.loginElements = new Hashtable<>();
        loginElements.put("Clear button", By.xpath("//*[contains(@resource-id, 'cl')]"));

        this.pageElements = loginElements;
    }
}
