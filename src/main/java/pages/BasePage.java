package pages;

import org.openqa.selenium.By;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class BasePage {
    public Dictionary<String, By> pageElements;
    public Dictionary<String, By> commonElements;

    public BasePage(){
        this.pageElements = new Hashtable<>();
        this.commonElements = new Hashtable<>();

        commonElements.put("Equal button", By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
        commonElements.put("Plus button", By.id("com.sec.android.app.popupcalculator:id/bt_add"));
        commonElements.put("Sub button", By.id("com.sec.android.app.popupcalculator:id/bt_sub"));
        commonElements.put("Multi button", By.id("com.sec.android.app.popupcalculator:id/bt_mul"));
        commonElements.put("Div button", By.id("com.sec.android.app.popupcalculator:id/bt_div"));
    }
}
