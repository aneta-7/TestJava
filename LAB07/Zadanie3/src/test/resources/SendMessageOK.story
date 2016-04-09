Scenario:  test send message ok
Given address server <server>
And message <message>
When message sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|inf.ug.edu.pl|some message|0|
|interia.pl|message|0|