Feature: Login
  Scenario Outline: Login into ZTrain application with correct mail and password
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User is logged in the app

    Examples:
      | Mail                 | Password     |
      | test.mail@email.com  | motsdepasse  |

  Scenario Outline: Login into ZTrain application with incorrect password
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User shouldn't be able to login due to incorrect password or login

    Examples:
      | Mail                 | Password       |
      | test.mail@email.com  | Wrongpassword  |

  Scenario Outline: Login into ZTrain application with incorrect mail
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User shouldn't be able to login due to incorrect password or login

    Examples:
      | Mail                 | Password       |
      | wrongmail@email.com  | motsdepasse    |

  Scenario Outline: Login into ZTrain application with incorrect mail and password
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User shouldn't be able to login due to incorrect password or login

    Examples:
      | Mail                 | Password       |
      | wrongmail@email.com  | Wrongpassword  |

  Scenario Outline: Login into ZTrain application with incorrect mail format
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    Then User shouldn't be able to login due to incorrect email format

    Examples:
      | Mail               | Password     |
      | wrongmailemailcom  | motsdepasse  |