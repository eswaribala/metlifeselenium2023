Feature: Upload file to the site demo.guru99.com test upload
  @UploadFile
  Scenario: Upload the file and Click on the upload button
    Given Visit site demo.guru99.com and check the path test upload
    When click on file upload type send the file
    Then Once file selected click upload button