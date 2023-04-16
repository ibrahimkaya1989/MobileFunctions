package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class LoginPage extends BasePage {

    public Hashtable<String, By> loginElements;

    public LoginPage(){
        super();
        this.loginElements = new Hashtable<>();
        loginElements.put("Clear button", By.id("com.coloros.calculator:id/clr"));
        loginElements.put("Clear1 button", By.id("com.sec.android.app.popupcalculator:id/bt_clear"));

        this.pageElements = loginElements;
    }
}
