package com.suirtech.automation.resttest.steps;

import com.suirtech.automation.resttest.TestConfig;
import com.suirtech.automation.resttest.actions.RequestHelper;
import com.suirtech.automation.resttest.client.TestAppClient;
import com.suirtech.automation.resttest.framework.CustomAssertions;
import com.suirtech.automation.resttest.framework.Session;
import com.suirtech.automation.resttest.model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class AllSteps {

    @Autowired
    private TestAppClient testAppClient;

    @Autowired
    private RequestHelper requestHelper;

    @Autowired
    private Session session;

    @Autowired
    private CustomAssertions customAssertions;


    @Given("^I have a new User with Unique UserName$")
    public void i_have_a_new_User_with_Unique_UserName() throws Throwable {
       session.setUser(requestHelper.createUniqueUser());
    }

    @When("^I save the new user to the service$")
    public void i_save_the_new_user_to_the_service() throws Throwable {
        testAppClient.saveUser(session.getUser());
    }

    @Then("^I can retrieve the user by Username$")
    public void i_can_retrieve_the_user_by_Username() throws Throwable {
        customAssertions.sAssertNotNull(testAppClient.getUserByUsername(session.getUser().getUserName()),"Saved user retrieved");
    }

    @Given("^I have user with username \"([^\"]*)\"$")
    public void iHaveUserWithUsername(String userName) throws Throwable {
        session.setUser(new User(userName));
    }

    @When("^I retrieve the user with username \"([^\"]*)\"$")
    public void iRetrieveTheUserWithUsername(String arg0) throws Throwable {
        session.setUser(testAppClient.getUserByUsername(session.getUser().getUserName()));
    }

    @Then("^I have the user  with username \"([^\"]*)\"$")
    public void iHaveTheUserWithUsername(String username) throws Throwable {
        customAssertions.sStringEquals(username, session.getUser().getUserName(),"User retrieved by username");
    }

    @Given("^I save a new User with Unique UserName$")
    public void iSaveANewUserWithUniqueUserName() throws Throwable {
        session.setUser(requestHelper.createUniqueUser());
        testAppClient.saveUser(session.getUser());
    }

    @When("^I delete the user$")
    public void iDeleteTheUser() throws Throwable {
        User deleteUser = testAppClient.getUserByUsername(session.getUser().getUserName());
        testAppClient.deleteUser(deleteUser.getId());
    }

    @Then("^I can not retrieve the user by Username$")
    public void iCanNotRetrieveTheUserByUsername() throws Throwable {
        customAssertions.sAssertNull(testAppClient.getUserByUsername(
                session.getUser().getUserName()),
                "Deleted user not retrieved");
    }

    @Given("^I have a have a Set of Users$")
    public void iHaveAHaveASetOfUsers() throws Throwable {
       for(int i = 0; i < 10; i++){
           session.setUser(requestHelper.createUniqueUser());
           testAppClient.saveUser(session.getUser());
       }
    }

    @Then("^I can get the Total count of Users$")
    public void iCanGetTheTotalCountOfUsers() throws Throwable {
        customAssertions.sMatchesRegex(String.valueOf(testAppClient.getCountOfUsers()), "^[0-9]*", "Total Users");
    }
}
