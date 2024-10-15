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

        commonElements.put("Equal button", By.xpath("//*[contains(@resource-id, 'btn_eq')]"));
        commonElements.put("Plus button", By.xpath("//*[contains(@resource-id, 'btn_add')]"));
        commonElements.put("Sub button", By.xpath("//*[contains(@resource-id, 'btn_sub')]"));
        commonElements.put("Multi button", By.xpath("//*[contains(@resource-id, 'btn_mul')]"));
        commonElements.put("Div button", By.xpath("//*[contains(@resource-id, 'btn_div')]"));
    }
}
