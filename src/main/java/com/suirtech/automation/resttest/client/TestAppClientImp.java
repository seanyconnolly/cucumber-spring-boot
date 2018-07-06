package com.suirtech.automation.resttest.client;

import com.suirtech.automation.resttest.model.User;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Data
@Component
public class TestAppClientImp implements TestAppClient {

    private static Logger logger = LogManager.getLogger(TestAppClientImp.class);

    public TestAppClientImp(){
        logger.info("client creaated");
    }

    @Autowired
    @Qualifier("testAppRestTemplate")
    private RestTemplate restTemplate;


    @Value("${testapp.url}")
    private String testAppUrl;


    @Override
    public User saveUser(User user) {
        String url = String.format("%s/user", testAppUrl);
        logger.info("Saving user  :: " + url);
        return restTemplate.postForObject(url, user, User.class);
    }

    @Override
    public User getUserByIndex(int index) {
        logger.info("getUserByIndex()");
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        String url = String.format("%s/userByUsername/%s", testAppUrl, username);
        logger.info("getUserByUsernam  :: " + url);
        return restTemplate.getForObject(url, User.class);
    }

    @Override
    public String getUrl() {
        return this.testAppUrl;
    }

    @Override
    public void deleteUser(Long id) {
        String url = String.format("%s/user/&d", testAppUrl, id);
        logger.info("deleting user  :: " + url);
        restTemplate.delete(url);
    }
}
