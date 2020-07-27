package ru.appline.framework.steps;

import ru.appline.framework.managers.InitManager;

public class BaseSteps {


    public static void setUp() {
        InitManager.initFramework();
    }

    public static void tearDown() {
        InitManager.quitFramework();
    }
}
