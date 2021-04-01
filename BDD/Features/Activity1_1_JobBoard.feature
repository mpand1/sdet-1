@activity1_1_JobBoard
Feature: Testing the Job Board application

Background: User opens the URL
	Given User opens the Browser

@TestCaseOne
Scenario: Create a new user
    Given User opens the Job Board Login Page
    When User logs in with "root" and "pa$$w0rd"
    Then Create a new User with providing necessary details on clicking on Users>>Add New button
    And Validate that the user has been created
    And Close FireFox Browser