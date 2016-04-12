Scenario:  Test MyTop empty
When the stack is empty
Then MyTop should throw an exception

Scenario: Test MyTop 
When Add new element <elem>
Then MyTop should be <elem>

Examples:
|elem|
|434|
|42|
|2|




