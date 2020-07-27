package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.fail;

public class MainPage extends BasePage{

    @FindBy(xpath = "//ul[@class='lg-menu__list']//span[text()]")
    private List<WebElement> mainMenuItems;

    @FindBy(xpath = "//ul[@class='lg-menu__sub-list']//a[text()]")
    private List<WebElement> subMenuItems;

    //select main menu item by text
    public void selectMainMenuItem(String itemText) {
        for (WebElement mainMenuItem : mainMenuItems) {
            if (mainMenuItem.getText().equalsIgnoreCase(itemText)) {
                waitUntilElementToBeClickable(mainMenuItem);
                actions.moveToElement(mainMenuItem).build().perform();
                return;
            }
        }
        fail(String.format("Cannot find element with text %s in main menu", itemText));
    }

    //select sub menu item by text and click it
    public void selectSubMenuItem(String itemText) {
        for (WebElement subMenuItem : subMenuItems) {
            if (subMenuItem.getText().equalsIgnoreCase(itemText)) {
                clickElement(subMenuItem);
                return;
            }
        }
        fail(String.format("Cannot find element with text %s in sub menu", itemText));
    }
}
