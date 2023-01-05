
@tag
Feature: Error validation 
  I want to use this template for my feature file

 
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
  Given I landed on Ecommerce page
    When logged  in with userName<name> and password<password>
    Then "Incorrect email or password." message is displayed on page.

    Examples: 
      | name                    | password   |
      | himaja.darsi25@gmail.com|Bujji.isu |
