Feature: Login to Sauce Demo
	Scenario: Successful login with valid credentials
		Given I am on the Sauce Demo login page
		When I enter username as "standard_user" and password as "secret_sauce"
		And I click the login button
		Then I should be redirected to the Sauce Demo inventory page
		
	Scenario Outline: Testing login with valid/invalid credentials
		Given I am on the Sauce Demo login page
		When I enter username as "<username>" and password as "<password>"
		And I click the login button
		Then I should see "<expected_result>"
		
		Examples:
		| username 			| password 			|	expected_result
		| standard_user | secret_sauce 	|	the inventory page display
		| error_user    | invalidPass		| the login page display