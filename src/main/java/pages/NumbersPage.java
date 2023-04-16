package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class NumbersPage extends BasePage {

    public Hashtable<String, By> numberElements;

    public NumbersPage(){
        super();
        this.numberElements = new Hashtable<>();
        numberElements.put("Number_0 button", By.id("com.coloros.calculator:id/digit_0"));
        numberElements.put("Number_1 button", By.id("com.coloros.calculator:id/digit_1"));
        numberElements.put("Number_2 button", By.id("com.coloros.calculator:id/digit_2"));
        numberElements.put("Number_3 button", By.id("com.coloros.calculator:id/digit_3"));
        numberElements.put("Number_4 button", By.id("com.coloros.calculator:id/digit_4"));
        numberElements.put("Number_5 button", By.id("com.coloros.calculator:id/digit_5"));
        numberElements.put("Number_6 button", By.id("com.coloros.calculator:id/digit_6"));
        numberElements.put("Number_7 button", By.id("com.coloros.calculator:id/digit_7"));
        numberElements.put("Number_8 button", By.id("com.coloros.calculator:id/digit_8"));
        numberElements.put("Number_9 button", By.id("com.coloros.calculator:id/digit_9"));
        numberElements.put("Number_00 button", By.id("com.sec.android.app.popupcalculator:id/bt_09"));

        this.pageElements = numberElements;
    }
}
