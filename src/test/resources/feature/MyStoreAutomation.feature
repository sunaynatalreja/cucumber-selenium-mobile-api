Feature: My Store Test Automation

Scenario Outline: Buy product of a given price

Given user is already on Home Page of "<url>" on "<browser>"
When user buys product of a given "<price>"
Then Close the browser


Examples:
	| price | url | browser | 
	| 27  | http://automationpractice.com/| chrome |