@google_search
Feature: Google search
  As a user I want to google search function
  Background: pre-requisties
    Given I open google search page
    When I accept cookies
  @smoke
  Scenario: Selenium
    When I lookup the word "selenium"
    Then search results display the word "selenium"
    And I click on the first result



