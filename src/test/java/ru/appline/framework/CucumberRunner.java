package ru.appline.framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        /*glue = {"stepdefs"},*/
        features = {"src/test/resources/"},
        tags = {"@checkCredit"}
)
public class CucumberRunner {
}
