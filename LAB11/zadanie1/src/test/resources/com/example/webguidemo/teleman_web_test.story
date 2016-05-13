Scenario: correct login
Given user on Login page
When user send login
When user send password
When user click button 
Then user login

Scenario: bad login
Given user on Login badPage
When user send badLogin 
When user send badPassword
When user click badButton 
Then user not login