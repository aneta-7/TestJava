Scenario: Test MyPop empty
Given the empty stack 
Then MyPop should throw an exception



Scenario: Test MyPop
Given the nonEmpty stack by <list>
When MyPop occurs
Then the top of stack should be <elem>

Examples:
|list|elem|
|8,3,76|3|
|1,1,1|1|
|3,2,1|2|
|4,3,5,7,2|7|
|2,5|2|
