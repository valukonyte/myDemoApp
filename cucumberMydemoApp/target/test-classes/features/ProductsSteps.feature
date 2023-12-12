Feature: Products page functionality
  Background: User is on Products page
    Given User is on "Products" page

  Scenario: User sorts products by name
    Given "sort button" functionality is available
    When User clicks "sort button" button
    And User clicks "nameAsc" button
    Then First product title is "Sauce Labs Backpack"

  Scenario Outline: User sorts products by name
    Given "sort button" functionality is available
    When User clicks "sort button" button
    And User clicks "<sortBy>" button
    Then First product title is "<title>"
    Examples:
      | sortBy   | title |
      | nameAsc | Sauce Labs Backpack |
      |nameDesc | Test.allTheThings() T-Shirt |
      |priceAsc | Sauce Labs Onesie |
      |priceDesc| Sauce Labs Fleece Jacket |