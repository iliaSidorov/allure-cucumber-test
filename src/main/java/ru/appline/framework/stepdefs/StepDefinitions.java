package ru.appline.framework.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.appline.framework.pages.CreditFormPage;
import ru.appline.framework.pages.CreditPage;
import ru.appline.framework.steps.CreditFormPageSteps;
import ru.appline.framework.steps.CreditPageSteps;
import ru.appline.framework.steps.MainPageSteps;

import java.lang.reflect.Type;

public class StepDefinitions {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private CreditPageSteps creditPageSteps = new CreditPageSteps();
    private CreditFormPageSteps creditFormPageSteps = new CreditFormPageSteps();

    @When("выбрано меню {string}")
    public void selectMenuItem(String item) {
        mainPageSteps.selectMenuItem(item);
    }

    @When("выбран вид ипотеки {string}")
    public void selectSubMenuItem(String subMenuItem) {
        mainPageSteps.selectSubMenuItem(subMenuItem);
    }

    @When("осуществлен переход к форме заявки")
    public void toApplicationForm() {
        creditPageSteps.toForm();
    }

    @When("заполняются поля:")
    public void fillForm(DataTable fields) {
        creditFormPageSteps.fillFields(fields.asMap(String.class, String.class));
    }

    @When("деактивирован чекбокс Страхование жизни")
    public void deactivateLifeInsurance() {
        creditFormPageSteps.deactivateLifeInsurance();
    }

    @When("активирован чекбокс Молодая семья")
    public void activateYoungFamily() {
        creditFormPageSteps.activateYoungFamily();
    }

    @Then("значения полей равны:")
    public void checkApplicationFormFilled(DataTable fields) {
        creditFormPageSteps.checkFilledFields(
                fields.asMap(String.class, String.class)
        );
    }


}
