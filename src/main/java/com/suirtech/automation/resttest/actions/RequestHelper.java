package com.suirtech.automation.resttest.actions;

import com.github.javafaker.Faker;
import com.suirtech.automation.resttest.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestHelper {


    private Faker faker = new Faker();

    public String getRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 5);
    }

    public User createUniqueUser() {
        return new User(
                faker.name().username() + getRandomString(),
                faker.internet().password(),
                faker.name().firstName(),
                faker.name().lastName()
        );
    }

}
