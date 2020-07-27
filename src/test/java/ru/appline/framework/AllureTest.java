package ru.appline.framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.appline.framework.steps.BaseSteps;
import ru.appline.framework.steps.CreditFormPageSteps;
import ru.appline.framework.steps.CreditPageSteps;
import ru.appline.framework.steps.MainPageSteps;

import java.util.HashMap;

import static ru.appline.framework.util.AllureUtils.addScreenshot;

public class AllureTest {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private CreditPageSteps creditPageSteps = new CreditPageSteps();
    private CreditFormPageSteps creditFormPageSteps = new CreditFormPageSteps();

    @Before
    public void setUp(){
        BaseSteps.setUp();
    }

    @Test
    public void checkCredit() {
        mainPageSteps
                .selectMenuItem("Ипотека")
                .selectSubMenuItem("Ипотека на готовое жильё");

        creditPageSteps
                .toForm();

        creditFormPageSteps
                .fillFields(new HashMap<String, String>() {{
                    put("Стоимость недвижимости", "5180000");
                    put("Первоначальный взнос", "3058000");
                    put("Срок кредита", "30");
                }})
                .deactivateLifeInsurance()
                .activateYoungFamily()
                .checkFilledFields(new HashMap<String, String>() {{
                    put("Ежемесячный платеж", "16922");
                    put("Сумма кредита", "2122000");
                    put("Процентная ставка", "11%");
                }});
    }

    @After
    public void tearDown(){
        addScreenshot();
        BaseSteps.tearDown();
    }
}
