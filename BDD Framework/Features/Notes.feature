Feature: Notes Creation

Scenario: Login and write a note followed by a logout
Given User opens URL "https://evernote.com/"
When User clicks on login link
Then User lands on "https://www.evernote.com/Login.action"
When User enters the valid email as "fahadalamgircsd@gmail.com"
And User clicks on login button
And User enters the password as "Mountain@5goat"
And User clicks on login button
Then homepage of the application should be displayed
When User clicks on create a new note tab and notespage of the application is displayed and User writes a note
When User clicks on logout button from the menu
Then  User lands on "https://www.evernote.com/Login.action"

Scenario: Login again and make sure you open the note created
Given User opens URL "https://evernote.com/"
When User clicks on login link
Then User lands on "https://www.evernote.com/Login.action"
When User enters the valid email as "fahadalamgircsd@gmail.com"
And User clicks on login button
And User enters the password as "Mountain@5goat"
And User clicks on login button
Then homepage of the application should be displayed
When User clicks on the written note tab
Then homepage of the application should be displayed
And written note title and paragragh is verified  