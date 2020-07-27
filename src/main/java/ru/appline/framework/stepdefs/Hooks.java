package ru.appline.framework.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.appline.framework.managers.InitManager;

import static ru.appline.framework.util.AllureUtils.addScreenshot;

public class Hooks {

    @Before
    public static void setUp() {
        InitManager.initFramework();
    }

    @After
    public static void tearDown() {
        addScreenshot();
        InitManager.quitFramework();
    }
}
