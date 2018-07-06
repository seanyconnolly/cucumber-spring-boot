package com.suirtech.automation.resttest;

import com.suirtech.automation.resttest.client.TestAppClientConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@Configuration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })@ComponentScan({
        "com.suirtech.automation.resttest"
})

@Import({
        TestAppClientConfig.class,
        com.suirtech.automation.resttest.client.TestAppClientConfig.class
})
@PropertySource("classpath:/${testConfig}.properties")
public class TestConfig {

}