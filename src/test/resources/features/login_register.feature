Feature: User Login and Logout

  Scenario: User logs in and logs out successfully
    Given user open the mamaEarth website
    When user verify the user is on the home page
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually
    Then user should be logged in successfully
    When user mouse over on the user icon or burger menu
    And user select logout
    Then user should see the logged out