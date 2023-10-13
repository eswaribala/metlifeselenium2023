Feature: Visit https://www.canada411.ca/, find people address
  Scenario: Find People Address using phone number, if exists show the address, else show not found message
    Given Visit https://www.canada411.ca/, Find people Phone number text box, enter phone number
    When Click on the search button
    Then If phone number exists show the address