Feature: Widgets
  Background: the start
    Given you are on ToolsQA main page
    When click on widgets
    Then it opens the widgets tab
  Scenario: Auto complete
    Given click on auto complete
    Then user writes a single color first letter
    Then user writes multiple colors
  Scenario Outline: Date picker
    Given clicks on date picker
    Then clicks on select date
    And selects a <year> and <month> and <day>
    Examples:
      | year | month | day|
      | 2021 | October | 24 |
  Scenario Outline: Slider
    Given clicks on slider
    Then moves slider to <value>
    Examples:
      | value |
      | 27      |
  Scenario Outline: Progress bar
    Given clicks on progress bar
    When clicks start and waits until <end>
    Then progress bar should be at <end>
    Examples:
      |end  |
      |  "45"   |
  Scenario: Menu
    Given clicks on menu
    When hover over item two