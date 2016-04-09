Scenario:  message has incorrect date
Given address server <server>
And message  <message>
When message sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|inter||2|