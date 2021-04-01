@activity2_4_HRM

Feature: Testing the OrangeHRM application

Background: User opens the URL
	Given User opens the FF Browser
	When Open the OrangeHRM page and login with credentials provided "orange" and "orangepassword123"
	
@TestCaseFour
Scenario:  Creating multiple vacancies
Scenario Outline: To Create multiple vacancies using data from an Examples table
    Given Navigate to the Recruitment Page
    When Click on the Vacancies menu item to navigate to the vacancies page
    Then Click on the Add button to navigate to the Add Job Vacancy form
    And Fill out the necessary details from example table as "<jTitle>" and "<vacName>" and "<hiringManager>" and "<noPosition>" and "<description>"
    And Click the Save button to save the vacancy
    And Verify that the vacancy was created by "<jTitle>" and "<vacName>"
    And Close the Browser
    
Examples:
|jTitle|vacName|hiringManager|noPosition|description|
|Android Developer|PythonDeveloper|Tony Stark|10|Good knowledge of Python is required|
|Automation Test Engineer|SeleniumTester|Tony Stark|5|Good knowledge of Selenium and JAVA is required|
|DevOps Engineer|DevOpsTester|Tony Stark|1|Good knowledge of DevOps is required|