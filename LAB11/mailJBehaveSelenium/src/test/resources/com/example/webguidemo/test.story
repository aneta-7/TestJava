Scenario: wp login
Given a wp login page
When send nameWp
When send passwordWp
When click loginWp
Then user is logWp


Scenario: onet login
Given a onet login page
When send nameOnet
When send passwordOnet
When click loginOnet
Then user is logOnet

Scenario: send email from onet to interia
Given a login user in onet
When click NowyList
When send odbiorca
When send tytul
When click wyslij
Then userInteria get a message

Scenario: send email from interia to onet
Given a login user in interia
When go to email account
When click nowaWiadomosc
When click WyslijNowa
Then userOnet get a message

Scenario: Delete SPAM in onet
Given a login userOnet
When go to SPAM
Then SPAM is empty
