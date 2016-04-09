Scenario: test bad connection
Given address server <server>
And bad connection
When address connection is tested
Then result should equal <result>

Examples:
|server|result|
|inf.ug.edu.pl|1|
|interia.pl|1|