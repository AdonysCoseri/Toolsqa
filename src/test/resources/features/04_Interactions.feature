Feature: Interactions
  Background: the start
    Given you are on the ToolsQA main page
    Then click on interactions
  Scenario Outline: Sortable
    Given click on Sortable
    And mixes them
    Then sorts them <type>
    Examples:
      | type |
      |Crescator|
  Scenario Outline: Selectable
    Given click on selectable
    And slects <one> and <second>
    Then <one> and <second> should be selected
    Examples:
      | one |second |
      |  1   |  2     |
  Scenario: Simple Droppable
    Given click on droppable
    When drops box
    Then box should be dropped
  Scenario: Accept droppable
    Given clicks on droppable and accept
    Then moves notAcceptable
    Then moves acceptable
  Scenario Outline: Simple Draggable
    Given click on draggable
    Then moves the box to <xoff> and <yoff>
    Examples:
      |xoff  |yoff |
      |  507 | 73  |
  Scenario Outline:Axis restricted
    Given click on draggable and Axis Restricted
    Then moves xbox to <xoff> and <yoff>
    Examples:
      | xoff | yoff |
      |  519 |  248  |
