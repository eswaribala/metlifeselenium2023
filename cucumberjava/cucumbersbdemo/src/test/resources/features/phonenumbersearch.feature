Feature: Visit www.canada411.ca, find people address
  @ValidPhoneNumber
  Scenario: Find People Address using phone number, if exists show the address, else show not found message
    Given Visit www.canada411.ca, Find people Phone number text box, enter phone number
    When Click on the search button
    Then If phone number exists show the address

  @InValidPhoneNumber
  Scenario: When non existing phone number given, show address not found message
    Given Visit www.canada411.ca, Find people Phone number text box, enter non existing phone number
    When Click on the non existing phone number search button
    Then show the address not found