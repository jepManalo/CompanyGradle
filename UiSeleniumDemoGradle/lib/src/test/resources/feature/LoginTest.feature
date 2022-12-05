@Login @Automated
Feature: Celonis Login Feature
  This feature tests the login functionality of EMS using a valid and invalid credentials


  Scenario: User Successfully logs in
    Given the user navigates to Celonis Login Page "https://applications.eu-1.celonis.cloud/ui/login"
    When the user enters a valid username and password
    Then the user is "successfully" Logged In
  
	Scenario Outline: User Unsuccessfully logs in
		Given the user navigates to Celonis Login Page "https://applications.eu-1.celonis.cloud/ui/login"
    When the user enters a invalid "<username>" and "<password>"
    Then the user is "unsuccessfully" Logged In
    
    Examples: 
      | username  								| password 	|
      | abc@gmail.com 						| abcde 		|
      | jeffreypmanalo@gmail.com 	| abcde 		|
      | jeffreypmanalo@gmail.com 	| 			 		|
      | 												 	| abcd	 		|