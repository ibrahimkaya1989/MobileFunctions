package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class NumbersPage extends BasePage {

    public Hashtable<String, By> numberElements;

    public NumbersPage(){
        super();
        this.numberElements = new Hashtable<>();
        numberElements.put("Number_0 button", By.id("com.sec.android.app.popupcalculator:id/bt_00"));
        numberElements.put("Number_1 button", By.id("com.sec.android.app.popupcalculator:id/bt_01"));
        numberElements.put("Number_2 button", By.id("com.sec.android.app.popupcalculator:id/bt_02"));
        numberElements.put("Number_3 button", By.id("com.sec.android.app.popupcalculator:id/bt_03"));
        numberElements.put("Number_4 button", By.id("com.sec.android.app.popupcalculator:id/bt_04"));
        numberElements.put("Number_5 button", By.id("com.sec.android.app.popupcalculator:id/bt_05"));
        numberElements.put("Number_6 button", By.id("com.sec.android.app.popupcalculator:id/bt_06"));
        numberElements.put("Number_7 button", By.id("com.sec.android.app.popupcalculator:id/bt_07"));
        numberElements.put("Number_8 button", By.id("com.sec.android.app.popupcalculator:id/bt_08"));
        numberElements.put("Number_9 button", By.id("com.sec.android.app.popupcalculator:id/bt_09"));

        this.pageElements = numberElements;
    }
}
