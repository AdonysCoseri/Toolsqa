Feature: ToolsQA testing
  Background: Testing the elements section
    Given user is on ToolsQA main page
    When user clicks on the Elements button
    Then it opens nine more options
  Scenario: click on the "check box" functionality
    Given user clicks on check box
    When user clicks on the button to see the full paths
    And selects some random checkboxes
    Then verifies if it worked
  Scenario: tabel test
    Given user clicks on web tables
    Then checks add
    And checks edit
    Then checks delete
    And prints a row
    Then prints a column
  Scenario: buttons test
    Given user clicks on buttons
    And user double clicks first button
    Then right clicks the second button
    And simple clicks last button
    Then all three messages should appear