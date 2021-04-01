@activity3_1_CRM

Feature: Testing the SuiteCRM application

Background: User opens the URL
	Given User opens the Mozilla FireFox Browser
	When Open the SuiteCRM page and login with credentials provided "admin" and "pa$$w0rd"

@TestCaseOne
Scenario: Counting Dashlets
Scenario Outline: Open the homepage and count the number of the dashlets on the page
    Given Count the number of Dashlets on the homepage
    When Print the number and title of each Dashlet into the console
    Then Close the FireFox browser