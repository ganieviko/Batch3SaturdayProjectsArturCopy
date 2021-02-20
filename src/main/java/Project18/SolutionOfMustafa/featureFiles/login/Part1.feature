Feature:  Adding a user and logging in by using the user we have created

  Background:
    Given User navigates to the  "http://thedemosite.co.uk/"


  Scenario Outline:
    And User clicks on "DemoPage"
      | addUserButton|
    When User sends the keys in "DemoPage"
      | username | <Username> |
      | password | <Password> |
    And User clicks on "DemoPage"
      | saveButton |
    Then Verify alert is "<Text>"

    Examples:
      | Username | Password | Text |
      |Mus      |  Mustafa |Username too short.  The username must be at least 4 characters in length.|
      |Navriz   |  Nav     |Password too short.  The password must be at least 4 characters in length.|
      |Mus      |  Nav     |Username too short.  The username must be at least 4 characters in length.|
      |Mustafa |  Navriz   |  |

  Scenario Outline:
    And User clicks on "DemoPage"
      | LoginButton|
    When User sends the keys in "DemoPage"
      | username | <Username> |
      | password | <Password> |
    And User clicks on "DemoPage"
      | TestLoginButton |
    Then Verify message is "<Expected Message>" in "DemoPage"
      |message|
    Examples:
      | Username | Password | Expected Message |
      |Mufatsa   |  Navriz  |**Failed Login**|
      |Mustafa   |  Zirvan  |**Failed Login**|
      |Afatsum   |  Zirvan  |**Failed Login**|
      |Mustafa   |  Navriz  |**Successful Login**|




   # And User selects "Hide" in the drop-down in "ManageCompanyPage"
   #  | VisibilityDropDown |


