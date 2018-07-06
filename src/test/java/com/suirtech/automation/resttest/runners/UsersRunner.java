package com.suirtech.automation.resttest.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Users.feature",
        glue = {
                "com.suirtech.automation.resttest.steps",
        },
        plugin = {
                "pretty",
                "json:target/cucumber_jsons/Users.json"
        },
        monochrome = true)
public class UsersRunner {



}
