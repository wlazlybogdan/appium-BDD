Feature: Adding new Contact
  Scenario: Alert should be Display when an user is not logged in
    Given I am not logged in
    When I click add new contact button
    Then alert should be displayed

    Scenario: Create new contact form should be displayed after alert dismiss
      Given I am not logged in
      And I click add new contact button
      When I dismiss alert
      Then Create ne contact from should be displayed

  Scenario: Discarding creating new contact
    Given I am in the create new contact form
    And I enter first name
    When I discard creating contact
    Then Discard alert should be displayed