package io.ctdev.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/io/ctdev/cucumber/features/SingUp.feature", glue = "")
public class TestRunner extends AbstractTestNGCucumberTests {

}
