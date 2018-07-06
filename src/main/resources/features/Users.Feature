Feature: Users

  Background: As An Automation Engineer I want to demonstrate cucumber tests on an api service

  @POST
  Scenario: Save a new user
    Given I have a new User with Unique UserName
    When I save the new user to the service
    Then I can retrieve the user by Username

  @GET
  Scenario Outline: Retrieve User by Username
    Given I have user with username "<username>"
    When I retrieve the user with username "<username>"
    Then I have the user  with username "<username>"

    Examples:
      | username  |
      | testUser1 |
      | testUser2 |
      | testUser3 |


  @DELETE
  Scenario: Delete user
    Given I save a new User with Unique UserName
    When I delete the user
    Then I can not retrieve the user by Username


  @GET
  Scenario: Total Users
    Given I have a have a Set of Users
    Then I can get the Total count of Users
