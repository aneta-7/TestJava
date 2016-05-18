Scenario: login
Given click login
When send name
When send password
Then user is login

Scenario: create ad
Given user is login
When go to create
When send data
When click create
Then user creane new ad



