package io.ctdev.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "smoke",
        glue = "io.ctdev.cucumber",
        features = "src/test/java/io/ctdev/cucumber/features/SingUp.feature")

public class TestRunner extends AbstractTestNGCucumberTests {
}
