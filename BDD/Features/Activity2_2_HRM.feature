@activity2_2_HRM

Feature: Testing the OrangeHRM application

Background: User opens the URL
	Given User opens the FF Browser
	When Open the OrangeHRM page and login with credentials provided "orange" and "orangepassword123"
	
@TestCaseTwo
Scenario:  Adding a candidate for recruitment
    Given Navigate to the Recruitment Page
    When Click on the Add button to add candidate information
    Then On the Add Candidate page fill in the details of the candidate
    And Upload a resume docx or pdf to the form
    And Click Save
    And Navigate back to the Recruitments page to confirm candidate entry
    And Close the Browser