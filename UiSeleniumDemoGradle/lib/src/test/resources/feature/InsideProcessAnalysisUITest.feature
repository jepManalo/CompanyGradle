@InsideAnalysisProcessVerification @Automated
Feature: Celonis element UI Test for Demo Analysis
  This is an element UI Test for the three demo analysis pages namely Order To Cash, Purchase To Pay
  and Service Now ticketing


  Scenario Outline: Verify elements for Analysis Pages
    Given the user navigates to Celonis Login Page "https://applications.eu-1.celonis.cloud/ui/login"
    	And the user successfully logs in to EMS
    When the user navigates to Process Analytics Page
    	And the user navigates to "<analysisPage>" Anaysis
    Then the user can verify "<analysisPage>" Analysis elements are displayed
    
    Examples: 
      | analysisPage  				|
      | Order To Cash					|
      | Purchase To Pay 			|
      | ServiceNow Ticketing 	|