Feature: Form
  Scenario: the start
    Given you are on the toolsQA main page
    Then click on form
    Then click on practice forms
  Scenario Outline: Names and Email Insertion
    Given user inserts <fName> and <lName>
    Then inserts <email>
    Examples:
      | fName | lName |       email       |
      |  Bob  |  Vance| bobvance@gmail.com|
  Scenario Outline: Gender and mobile number
    Given user selects <gender>
    Then user selectss <number>
    Examples:
      | gender |number  |
      |  Male  | 1234567890   |
  Scenario Outline: Date of Birth
    Given user clicks on birthPicker
    Then Selects <Month> <Year> and <Day>
    Examples:
      |Month  |Year|Day|
      |       |    |   |