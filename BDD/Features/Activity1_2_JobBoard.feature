@activity1_2_JobBoard
Feature: Testing the Job Board application

Background: User opens the URL
	Given User opens the Browser
    
@TestCaseTwo
Scenario: Searching for jobs using XPath
    Given User opens the Job Board Page
    And Navigate to the Job Page
    When Find the Keyword and Type in keywords to search for jobs and change the Job type
    Then Find the filter using XPath and filter job type to show only Full Time jobs
    And Find a job listing using XPath and it to see job details
    And Find the title of the job listing using XPath and print it to the console
    And Find and Click on the Apply for job button
    And Close FireFox Browser
    	
