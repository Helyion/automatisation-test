Feature: Research
  Scenario Outline: Research of Ampoule in electronic category
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    And User do a research "<Research>"
    And User select the electronic category
    Then The all category is selected
    Then User find "<Result>" article


    Examples:
      | Mail                 | Password     | Research | Result                       |
      | test.mail@email.com  | motsdepasse  | Ampoule  | Ampoule Vecteur Incandescent |

  Scenario Outline: Research of Ampoule in all category
    Given User launched login page of ZTrain application
    When User logged in the app using mail "<Mail>" and password "<Password>"
    And User do a research "<Research>"
    And User select the all category
    Then The all category is selected
    Then User find "<Result>" article


    Examples:
      | Mail                 | Password     | Research | Result                       |
      | test.mail@email.com  | motsdepasse  | Ampoule  | Ampoule Vecteur Incandescent |
