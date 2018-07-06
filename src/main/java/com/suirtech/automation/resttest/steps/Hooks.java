package com.suirtech.automation.resttest.steps;

import com.suirtech.automation.resttest.framework.Session;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    private static Logger logger = LogManager.getLogger(Hooks.class);

    @Autowired
    private Session session;

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("*********************************************");
        logger.info("BEFORE SCENARIO ::: " + scenario.getName());
        logger.info("*********************************************");
        session.setScenario(scenario);
    }

    @After
    public void afterScenario() {
        logger.info("*********************************************");
        logger.info("After SCENARIO ::: " + session.getScenario().getName() + " : " + session.getScenario().getStatus());
        logger.info("*********************************************");
    }
}
