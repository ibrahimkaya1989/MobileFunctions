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

        commonElements.put("Equal button", By.id("com.coloros.calculator:id/eq"));
        commonElements.put("Plus button", By.id("com.coloros.calculator:id/op_add"));
        commonElements.put("Sub button", By.id("com.coloros.calculator:id/op_sub"));
        commonElements.put("Multi button", By.id("com.coloros.calculator:id/op_mul"));
        commonElements.put("Div button", By.id("com.coloros.calculator:id/op_div"));

        commonElements.put("Equal1 button", By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
        commonElements.put("Plus1 button", By.id("com.sec.android.app.popupcalculator:id/bt_add"));
        commonElements.put("Sub1 button", By.id("com.sec.android.app.popupcalculator:id/bt_sub"));
        commonElements.put("Multi1 button", By.id("com.sec.android.app.popupcalculator:id/bt_mul"));
        commonElements.put("Div1 button", By.id("com.sec.android.app.popupcalculator:id/bt_div"));
    }
}
