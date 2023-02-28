Feature: Register
  Scenario Outline: Register into ZTrain application with correct mail and password
    Given User launched register page of ZTrain application
    When User fill the register form with the email "<Mail>" and password "<Password>" and the confirmation password "<ConfPassword>"
    Then User is register

    Examples: #Changer à chaque test
      | Mail                      | Password  | ConfPassword |
      | register.mail@email.com   | password  | password     |

  Scenario Outline: Register into ZTrain application with incorrect mail format
    Given User launched register page of ZTrain application
    When User fill the register form with the email "<Mail>" and password "<Password>" and the confirmation password "<ConfPassword>"
    Then User shouldn't be able to register due to incorrect email format

    Examples:
      | Mail                   | Password  | ConfPassword |
      | registermailemailcom   | password  | password     |

  Scenario Outline: Register into ZTrain application with mail already register
    Given User launched register page of ZTrain application
    When User fill the register form with the email "<Mail>" and password "<Password>" and the confirmation password "<ConfPassword>"
    Then User shouldn't be able to register due to the email already register

    Examples:
      | Mail                      | Password  | ConfPassword |
      | register.mail@email.com   | password  | password     |

  Scenario Outline: Register into ZTrain application with the two password not identical
    Given User launched register page of ZTrain application
    When User fill the register form with the email "<Mail>" and password "<Password>" and the confirmation password "<ConfPassword>"
    Then User shouldn't be able to register due to the two password not being identical

    Examples:
      | Mail                      | Password  | ConfPassword |
      | testError.mail@email.com   | passworA  | password     |
      | testError.mail@email.com   | password  | passworA     |

  Scenario Outline: Register into ZTrain application with the two password not identical
    Given User launched register page of ZTrain application
    When User fill the register form with the email "<Mail>" and password "<Password>" and the confirmation password "<ConfPassword>"
    Then User shouldn't be able to register due to the two password not being long enough

    Examples:
      | Mail                      | Password  | ConfPassword |
      | testError.mail@email.com  | 1         | 1            |
      | testError.mail@email.com  | 1234567   | 1234567      |