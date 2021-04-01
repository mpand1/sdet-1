@activity1_4_JobBoard
Feature: Testing the Job Board application

Background: User opens the URL
	Given User opens the Browser

@TestCaseFour
Scenario Outline: Posting a job using Examples
    Given User opens the Job Board Page
    And Navigate to the Post Job Page
    When User provides the information "<eMail>" , "<title>" , "<location>" , "<jobDescription>" , "<companyURL>" and "<companyName>"
    Then Click submit
    And Go to the Jobs page
    And Confirm job listing is shown on page with Job Name and Location as "SDET Developer Tester" and "Bengaluru"
    And Close FireFox Browser
    
Examples:
|eMail|title|location|jobDescription|companyURL|companyName|
|abcdefghijtestt12@hotmail.com|SDET Developer Tester|Bengaluru|We want a tester who have knowledge of JAVA, Python, Selenium, TestNG, ReportNG, Cucumber, Jira, Zypher and Manual Testing|glctestjob2@gmail.com|IBM India Pvt Ltd|
