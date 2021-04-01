@activity3_3_CRM

Feature: Testing the SuiteCRM application

Background: User opens the URL
	Given User opens the Mozilla FireFox Browser
	When Open the SuiteCRM page and login with credentials provided "admin" and "pa$$w0rd"

@TestCaseThree
Scenario: Schedule a meeting and invite members
Scenario Outline: To schedule a meeting and include at least 3 invitees
    Given Navigate to Activities -> Meetings -> Schedule a Meeting
    When Enter the details of the meeting
    Then Search for members and add them to the meeting with:
    |fName|
    |Kanti|
    |Jamila|
	  |Test123|
    And Click On Save
    And Navigate to View Meetings page and confirm creation of the meeting
    And Close the FireFox browser
