@activity1_3_JobBoard
Feature: Testing the Job Board application

Background: User opens the URL
	Given User opens the Browser
	
@TestCaseThree
Scenario: Posting a job using parameterization
    Given User opens the Job Board Page
    And Navigate to the Post Job Page
    When User provides the information "glcctest678@gmail.com" , "SDET Tester" , "Bangalore" , "We want a tester who have knowledge of JAVA, Python, Selenium, TestNG, ReportNG, Cucumber, Jira, Zypher and Manual Testing" , "glcctestjob@gmail.com" and "IBM India Pvt Ltd"  
    Then Click submit
    And Go to the Jobs page
    And Confirm job listing is shown on page with Job Name and Location as "SDET Tester" and "Bangalore"
    And Close FireFox Browser