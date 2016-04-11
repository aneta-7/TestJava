Scenario: Test IsEmpty true if empty
Given the empty stack
Then IsEmpty should be true


Scenario: Test IsEmpty false if not empty
Given the stack by <list>
Then IsEmpty should be false

Examples:
|list|
|1,3|
|7,8|
|3|


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

Scenario: Test MyPush
Given an element by <elem>
When an element is added to the stack
Then the stack should have <elem>

Examples:
|elem|
|9|
|53|

	 
Scenario:  Test MyTop empty
When the stack is empty
Then MyTop should throw an exception

Scenario: Test MyTop 
When the nonEmpty stack by <list>
Then MyTop should be <top>

Examples:
|list|top|
|43,432,4|4|
|42,43|43|
|2|2|




