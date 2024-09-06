Feature: User Login and Logout

  Background: User login with mobile and enter otp
    Given user open the mamaEarth application
    When user verify the user is on the home page
    And user click on the user icon
    Then user should see the login page
    When user log in with mobile number "user.mobileNumber"
    Then user enter OTP manually

  @web
  Scenario: User login and logout successfully in web
    Then user should be logged in successfully
    When user mouse over on the user icon or burger menu
    And user select logout
    Then user should see the logged out

    @web @mobile
  Scenario: User login and logout successfully in mobile
    When close the account page
    Then user should be logged in successfully
    When user mouse over on the user icon or burger menu
    And user select logout
    Then user should see the logged out