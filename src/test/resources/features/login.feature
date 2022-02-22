@login
Feature: User should be able to login

  Background:
    Given the user is on the login page


  Scenario: Login as a valid user
    When the user enters the valid "Point of Sales Manager" information
    Then the user should able to get title ""

  Scenario Outline:
    When the user enters the invalid_empty "<userName>" or "<passWord>"
    Then the user should get error message "Wrong login/password"
    Examples:
      | userName | passWord |
      | use      | password |
      | username | pass     |
      |          | password |
      | username |          |