package ru.appline.framework.steps;

import io.qameta.allure.Step;
import ru.appline.framework.pages.MainPage;

public class MainPageSteps {

    @Step("выбрано меню ипотека")
    public MainPageSteps selectMenuItem(String itemText) {
        MainPage mainPage = new MainPage();
        mainPage.selectMainMenuItem(itemText);
        return this;
    }

    @Step("выбрано подменю Ипотека на готовое жилье")
    public void selectSubMenuItem(String itemText) {
        MainPage mainPage = new MainPage();
        mainPage.selectSubMenuItem(itemText);
    }
}
