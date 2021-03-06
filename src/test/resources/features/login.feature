@login
Feature: User should be able to login

  Background:
    Given the user is on the login page


  Scenario: Login as a valid user
    When the user enters the valid "Point of Sales Manager" information
    Then the user should able to get title "Odoo"


  Scenario Outline:
    When the user should enter valid "<userName>" and valid "<passWord>"
    Then the user should able to get title "Odoo"
    And the user should able to get actual "<userType>"
    Examples:
      | userName                   | passWord         | userType            |
      | salesmanager15@info.com    | salesmanager     | SalesManager15      |
      | posmanager10@info.com      | posmanager       | POSManager10        |
      | imm10@info.com             | inventorymanager | InventoryManager10  |
      | expensesmanager10@info.com | expensesmanager  | ExpensesManager10   |
      | manuf_user10@info.com      | manufuser        | ManufacturingUser10 |

  Scenario Outline:
    When the user enters the invalid_empty "<userName>" or "<passWord>"
    Then the user should get error message "Wrong login/password"
    Examples:
      | userName              | passWord   |
      | posmanager10@info.com | password   |
      | username              | posmanager |


  Scenario Outline:
    When the user enters the invalid_empty "<userName>" or "<passWord>"
    Then the user should get caution message "Lütfen bu alanı doldurun."
    Examples:
      | userName              | passWord   |
      | posmanager10@info.com |            |
      |                       | posmanager |
      |                       |            |
  @wip
  Scenario: Reset Password Button
    When the user clicks the reset password button
    Then the user should able to get title "Reset password | Best solution for startups"
