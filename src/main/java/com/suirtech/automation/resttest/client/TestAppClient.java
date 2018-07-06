package com.suirtech.automation.resttest.client;

import com.suirtech.automation.resttest.model.User;

public interface TestAppClient {

    User saveUser(User user);

    User getUserByIndex(int index);

    User getUserByUsername(String username);

    String getUrl();

    void deleteUser(Long id);


}
