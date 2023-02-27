Scenario: login
Given User launched ZTrain application
When User logged in the app using the correct mail <mail> and password <password>
Then User is logged in the app

Examples:
  | mail                 | password     |
  | test.mail@email.com  | motsdepasse  |