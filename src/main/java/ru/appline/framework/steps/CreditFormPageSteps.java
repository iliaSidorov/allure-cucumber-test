package ru.appline.framework.steps;

import io.qameta.allure.Step;
import ru.appline.framework.pages.CreditFormPage;
import ru.appline.framework.util.AllureUtils;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class CreditFormPageSteps {

    @Step("заполняются поля")
    public CreditFormPageSteps fillFields(HashMap<String, String> fields) {
        fields.forEach(this::fillField);
        return this;
    }

    @Step("поле {field} заполняется значением {value}")
    public CreditFormPageSteps fillField(String field, String value) {
        CreditFormPage creditFormPage = new CreditFormPage();
        creditFormPage.fillField(field, value);
        return this;
    }

    @Step("деактивирован чекбокс 'Страхование жизни'")
    public CreditFormPageSteps deactivateLifeInsurance() {
        CreditFormPage creditFormPage = new CreditFormPage();
        creditFormPage.switchLifeInsuranceCheckbox();
        return this;
    }

    @Step("активирован чекбокс 'Молодая семья'")
    public CreditFormPageSteps activateYoungFamily() {
        CreditFormPage creditFormPage = new CreditFormPage();
        creditFormPage.switchYoungFamilyCheckbox();
        return this;
    }

    @Step("выполнена проверка заполнения полей:")
    public CreditFormPageSteps checkFilledFields(HashMap<String, String> fields) {
        fields.forEach(this::checkFilledField);
        return this;
    }

    @Step("поле {field} заполнено значением {value}")
    private void checkFilledField(String field, String value) {
        CreditFormPage creditFormPage = new CreditFormPage();
        String actual = creditFormPage.getFilledField(field);
        assertTrue(String.format("The value of the field %s equals %s. Expected - %s", field, actual, value),
                actual.equals(value));

        AllureUtils.addScreenshot();
    }


}
