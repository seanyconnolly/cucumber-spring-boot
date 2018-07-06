package com.suirtech.automation.resttest.framework;


import com.suirtech.automation.resttest.model.User;
import cucumber.api.Scenario;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Session {

    private Scenario scenario;

    private User user;
}
