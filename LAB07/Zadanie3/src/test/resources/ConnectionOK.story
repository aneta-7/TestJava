Scenario: test ok connection
Given address server <server>
And ok connection
When address connection is tested
Then result should equal <result>

Examples:
|server|result|
|inf.ug.edu.pl|0|
|interia.pl|0|