Scenario:  test send message bad
Given address server <server>
And message <message>
When message can't sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|inf.ug.edu.pl|some message|1|
|interia.pl|message|1|