package ru.appline.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static ru.appline.framework.managers.DriverManager.getDriver;

public class BasePage {

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);
    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();
    protected Actions actions = new Actions(getDriver());

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void setTimeout(long time) {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    protected void clickElement(WebElement element) {
        waitUntilElementToBeClickable(element).click();
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void switchToFrame(WebElement frame) {
        getDriver().switchTo().frame(frame);
    }
}
