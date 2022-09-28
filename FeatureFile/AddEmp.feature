Feature: AddNew Employee
As a admin user should create multiple employees
Scenario Outline:
Validate add Employee
Given  User launch url "http://orangehrm.qedgetech.com/"
When user Enter username as "Admin" and password as "Qedge123!@#"
When user click login button
When user click pim
When user click add button
When Fill Add Employee "<Fname>" and "<Mname>" and "<Lname>"
When User capture EmId Before
When User click save button
When uer capture EmId After
Then user validates emid
Then user close browser
Then user checking login
Examples:
|Fname|Mname|Lname|
|Testing1|Selenium1|Manual1|
|Testing6|Selenium6|Manual6|
|Testing5|Selenium5|Manual5|
|Sunil|Kumar|Navuri|
|Pradeep|Kumar|Navuri|
|Ravi|Kiran|Kumar|
|Rupa|Lavanya|Gudimetla|
|Testing8|Selenium9|Manaul9|
