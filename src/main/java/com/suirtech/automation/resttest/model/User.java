package com.suirtech.automation.resttest.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {


    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User(){

    }

    public User(String userName){
        this.userName = userName;
    }

    public User(String userName, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

}
