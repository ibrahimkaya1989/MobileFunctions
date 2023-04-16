package constants;

import org.openqa.selenium.By;

public class Locators {

    public static By ById(String id){
        System.out.println("Looking for : " + id );
        return By.xpath("//*[contains(@resource-id, '" + id + "') or contains(@id, '" + id + "')]");
    }

    public static By ByText(String text){
        System.out.println("Looking for : " + text) ;
        return By.xpath("//*[contains(@text, '" + text + "')]");
    }
}
