@activity3_2_CRM

Feature: Testing the SuiteCRM application

Background: User opens the URL
	Given User opens the Mozilla FireFox Browser
	When Open the SuiteCRM page and login with credentials provided "admin" and "pa$$w0rd"

@TestCaseTwo
Scenario: Create leads using parameterization
    Given Navigate to Sales -> Leads -> Create Lead
    When Fill in the necessary details to create lead accounts using the values passed from the Feature file as "Mr." and "Kiran" and "Raj" and "gglctest12@hotmail.com"
    Then Click Save to finish
    And Navigate to the View Leads page to see results as "Mr." and "Kiran" and "Raj"
    And Close the FireFox browser