Feature: Create API Test Automation

Scenario Outline: Buy product of a given price

Given Running Create API
Then Close the browser


Examples:
	| price | url | browser | 
	| 27  | http://automationpractice.com/| chrome |