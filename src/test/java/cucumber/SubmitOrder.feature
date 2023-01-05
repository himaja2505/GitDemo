
@tag
Feature: submit  the order from e-commerce website.
  I want to use this template for my feature file
Background:
Given I landed on Ecommerce page
  
  @Regression
  Scenario Outline: positive test of submitting the order
    Given logged  in with userName<name> and password<password>
    When I add products<productName> to cart
    And checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed on confirmation page.

    Examples: 
      | name                    | password   | productName  |
      | himaja.darsi25@gmail.com|Bujji.isu25 | ZARA COAT 3|
     
