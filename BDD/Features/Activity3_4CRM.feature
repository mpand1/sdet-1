@activity3_4_CRM

Feature: Testing the SuiteCRM application

Background: User opens the URL
	Given User opens the Mozilla FireFox Browser
	When Open the SuiteCRM page and login with credentials provided "admin" and "pa$$w0rd"
	
@TestCaseFour
Scenario: Creating a Product
Scenario Outline: To use an Examples table to add products  
	Given Navigate to All -> Products-> Create Product
    When Retrieve information about the product as "<productName>" and "<price>" and "<description>"
    Then Click On Product Save Button
    And Go to the View Products page to see all products listed as "<productName>"
    And Close the FireFox browser
    
Examples:
|productName|price|description|
|Appium|10|Commonly used for mobile automation|
|Selenium|10|Commonly used automation testing tool using Java|
|Jira|10|Commonly used defect management|
