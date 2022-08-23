Feature: Edit the existing Lead details in the LeafTaps Application

Background: Positive Login
Given Type the username as 'DemoSalesManager'
And Type the password as 'crmsfa'
When Click on the Login button
Then Verify the home page is displayed


Scenario Outline: Edit Lead with different data
Given Click CRMSFA Link
And Click Leads Tab
And Click Find Leads Tab
When Enter the first name as <firstName>
And Click Find Leads Button
And Click the first Lead id link in the list 
And Click Edit button
And Enter the last name as <lastName>
And Click on Update button
Then Verify the updated last Name as <lastName>

Examples:
|firstName|lastName|
|Babu|M|
|Hari|Kumar|