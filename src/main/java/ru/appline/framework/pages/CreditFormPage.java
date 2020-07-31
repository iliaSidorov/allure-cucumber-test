package ru.appline.framework.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreditFormPage extends BasePage {

    @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input")
    private WebElement creditTotalInput;

    @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    private WebElement initialPaymentInput;

    @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    private WebElement creditTermsInput;

    @FindBy(xpath = "//div[contains(@data-e2e-id, 'discounts-block')]//input[contains(@data-e2e-id, 'item-2')]")
    private WebElement lifeInsuranceCheckbox;

    @FindBy(xpath = "//div[contains(@data-e2e-id, 'discounts-block')]//input[contains(@data-e2e-id, 'item-6')]")
    private WebElement youngFamilyCheckbox;

    @FindBy(xpath = "//div[contains(@data-e2e-id, 'discounts-block')]")
    private WebElement discountBlock;

    @FindBy(xpath = "//div[@class='styles_resultSection__37omF']//span[contains(@data-e2e-id, 'monthly-payment')]//span")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//div[@class='styles_resultSection__37omF']//span[contains(@data-e2e-id, 'credit-sum')]//span")
    private WebElement creditSum;

    @FindBy(xpath = "//div[@class='styles_resultSection__37omF']//span[contains(@data-e2e-id, 'credit-rate')]//span")
    private WebElement creditRate;

    @FindBy(xpath = "//div[@class='styles_resultSection__37omF']")
    private WebElement resultSection;


    public CreditFormPage fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fillField(creditTotalInput, value);
                break;
            case "Первоначальный взнос":
                fillField(initialPaymentInput, value);
                break;
            case "Срок кредита":
                fillField(creditTermsInput, value);
                break;
            default:
                throw new AssertionError("There is no field " + fieldName + " on the page");
        }
        return this;
    }

    public CreditFormPage switchLifeInsuranceCheckbox() {
        scrollToElementJs(discountBlock);
        lifeInsuranceCheckbox.click();
        return this;
    }

    public CreditFormPage switchYoungFamilyCheckbox() {
        scrollToElementJs(discountBlock);
        youngFamilyCheckbox.click();
        return this;
    }

    private void fillField(WebElement field, String value) {
        field.click();
        field.sendKeys(Keys.CONTROL, "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
    }

    public String getFilledField(String fieldName) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scrollToElementJs(resultSection);

        switch (fieldName) {
            case "Ежемесячный платеж":
                return monthlyPayment.getText().replaceAll("\\D+", "");
            case "Сумма кредита":
                return creditSum.getText().replaceAll("\\D+", "");
            case "Процентная ставка":
                return creditRate.getText();
        }
        throw new AssertionError("No such field on the page");
    }
}
