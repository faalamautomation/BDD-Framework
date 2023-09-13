Feature: Login

Scenario: Unsuccessful login using email
Given User opens URL "https://evernote.com/"
When User clicks on login link
Then User lands on "https://www.evernote.com/Login.action"
When User enters the invalid email as "fahadalamgirpsd@gmail.com"
And User clicks on login button
Then "There is no account for the username or email you entered." message should be displayed on the login page

Scenario: Successful login using email
Given User opens URL "https://evernote.com/"
When User clicks on login link
Then User lands on "https://www.evernote.com/Login.action"
When User enters the valid email as "fahadalamgircsd@gmail.com"
And User clicks on login button
And User enters the password as "Mountain@5goat"
And User clicks on login button
Then homepage of the application should be displayed