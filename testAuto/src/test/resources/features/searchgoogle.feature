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

  Scenario: cucumber
    When I lookup the word "cucumber"
    Then search results display the word "cucumber"
  @ignore
  Scenario Outline: <lookup_word>
    When I lookup the word "<lookup_word>"
    Then search results display the word "<lookup_word>"
    Examples:
    |lookup_word|expected_result|
    |restassured|restassured    |
    |java|fail                  |

