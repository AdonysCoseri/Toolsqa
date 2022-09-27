Feature: Alerts Test
  Background: the start
    Given user is on ToolsqA main page
    When user clicks on Alerts button
    Then it opens five more options
  Scenario: Browser windows
    Given user clicks on BW
    When user clicks new tab
    Then user clicks new window
    Then user click window message
  Scenario:  Alerts
    Given user clicks on alerts
    Then click on alert
    And click on timerAlert
    Then clicks on confirmAlert
    Then clicks on prompt box
  Scenario: Modals
    Given user clicks on modal dialogs
    Then click small modal
    And click large modal
