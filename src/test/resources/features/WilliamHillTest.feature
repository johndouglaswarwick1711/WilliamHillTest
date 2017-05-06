Feature: As a user I want to navigate to an event and place a bet
  Scenario Outline: As a user I want to login and navigate to an event and place a bet

    Given I logon to William Hill with "<username>" and "<password>"
    And   Navigate to "<event>"
    When  I place a bet of "<bet_amount>"
    Then  I check that "<total_stake>" and resulting balances are correct

    Examples:
      | username | password | event    | bet_amount | total_stake |
      |WHATA_FOG2|F0gUaTtest|football  | 0.05       |     0.05    |
