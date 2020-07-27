package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditPage extends BasePage {

    @FindBy(xpath = "//iframe[@title='Основной контент']")
    private WebElement frame;

    //switch to iframe with application form
    public void toForm() {
        scrollToElementJs(frame);
        switchToFrame(frame);
    }
}
