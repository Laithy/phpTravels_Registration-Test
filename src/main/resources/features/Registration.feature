Feature: User should be able to make a new account

#    First name can't be the same as Last name
#    Both must start with a capital letter
#    Password must consists of 8 characters including one lower case character and one upper case character

  Scenario: User registers with valid data
    Given The user opens the browser
    And Navigates to the site "https://phptravels.net/signup"
    When The user enters his first name "Mahmoud" in the first name field
    And enters his Last name "El-laithy" in the last name field
    And Picks his home country "egypt"
    And Enters his Mobile number "01116628978"
    And Enters his valid email "Mahmoudelaithy@gmail.com" in the email field
    And Enters his valid password "A123456a" in the password field
#    And Check the captcha box
#    And Press the Signup button
#    Then User should see a success msg "Your account has been created"
    And Close the browser
