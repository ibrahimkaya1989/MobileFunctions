package pages;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class NumbersPage extends BasePage {

    public Hashtable<String, By> numberElements;

    public NumbersPage(){
        super();
        this.numberElements = new Hashtable<>();
        numberElements.put("Number_0 button", By.xpath("//*[contains(@resource-id, '00')]"));
        numberElements.put("Number_1 button", By.xpath("//*[contains(@resource-id, '01')]"));
        numberElements.put("Number_2 button", By.xpath("//*[contains(@resource-id, '02')]"));
        numberElements.put("Number_3 button", By.xpath("//*[contains(@resource-id, '03')]"));
        numberElements.put("Number_4 button", By.xpath("//*[contains(@resource-id, '04')]"));
        numberElements.put("Number_5 button", By.xpath("//*[contains(@resource-id, '05')]"));
        numberElements.put("Number_6 button", By.xpath("//*[contains(@resource-id, '06')]"));
        numberElements.put("Number_7 button", By.xpath("//*[contains(@resource-id, '07')]"));
        numberElements.put("Number_8 button", By.xpath("//*[contains(@resource-id, '08')]"));
        numberElements.put("Number_9 button", By.xpath("//*[contains(@resource-id, '09')]"));

        this.pageElements = numberElements;
    }
}
