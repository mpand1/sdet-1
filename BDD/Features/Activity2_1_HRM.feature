@activity2_1_HRM

Feature: Testing the OrangeHRM application

Background: User opens the URL
	Given User opens the FF Browser
	When Open the OrangeHRM page and login with credentials provided "orange" and "orangepassword123"
@TestCaseOne
Scenario: Creating a job vacancy
    Given Navigate to the Recruitment page
    When Click on the Vacancies menu item to navigate to the vacancies page
    Then Click on the Add button to navigate to the Add Job Vacancy form
    And Fill out the necessary details
    And Click the Save button to save the vacancy
    And Verify that the vacancy was created
    And Close the Browser