Feature: Login Functionality tests for Campus website

  Background:
  Given User navigates to the  "https://test.campus.techno.study/"


  Scenario Outline: User can login with valid credentials
    When User sends the keys in "TestCampusPage"
      | username | <Username> |
      | password | <Password> |
    And User clicks on "TestCampusPage"
      | LoginButton |
    Then Verify message is "<Expected Message>" in "TestCampusPage"
      | Dashboard |

    Examples:
      | Username          | Password        | Expected Message |
      | daulet2030@gmail.com | TechnoStudy123@ | Dashboard        |


  Scenario Outline: User can not login with invalid credentials
    When User sends the keys in "TestCampusPage"
      | username | <Username> |
      | password | <Password> |
    And User clicks on "TestCampusPage"
      | LoginButton |
    Then Verify message is "<Expected Message>" in "TestCampusPage"
      | ErrorElement |

    Examples:
      | Username             | Password        | Expected Message                  |
      | daulet2030@gmail.com | TechnoStudy     | Invalid username or password      |
      | dau2030@gmail.com    | TechnoStudy     | Invalid username or password      |
      | dau2030@gmail.com    |                 | Keys to send should be a not null |
      |                      | TechnoStudy123@ | Keys to send should be a not null |
      |                      |                 | Keys to send should be a not null |