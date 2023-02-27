Feature: Login
  Scenario Outline: Login into ZTrain application with correct mail and password
    Given User launched ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User is logged in the app

Examples:
  | Mail                 | Password     |
  | test.mail@email.com  | motsdepasse  |