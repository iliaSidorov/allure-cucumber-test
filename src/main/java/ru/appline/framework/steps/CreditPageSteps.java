package ru.appline.framework.steps;

import io.qameta.allure.Step;
import ru.appline.framework.pages.CreditPage;

public class CreditPageSteps {

    @Step("осуществлен переход к форме заполнения")
    public void toForm() {
        CreditPage creditPage = new CreditPage();
        creditPage.toForm();
    }
}
