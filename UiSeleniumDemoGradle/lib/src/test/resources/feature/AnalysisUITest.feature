@AnalysisVerification @Automated
Feature: Celonis UI Test for Demo Analysis
  This is a UI Test for the three demo analysis pages namely Order To Cash, Purchase To Pay
  and Service Now ticketing


  Scenario Outline: Verify Existence of Order To Cash Analysis
    Given the user navigates to Celonis Login Page "https://applications.eu-1.celonis.cloud/ui/login"
    	And the user successfully logs in to EMS
    When the user navigates to Process Analytics Page
    Then the user can verify "<demoAnalysis>" Analysis is displayed
    
    Examples:
    	| demoAnalysis 					|
    	| Order To Cash					|
    	| Purchase To Pay 			|
    	| ServiceNow Ticketing	|