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

Scenario: Test MyPop
Given the nonEmpty stack by <list>
When MyPop occurs
Then the top of stack should be <elem>

Examples:
|list|elem|
|8,3,76|3|

Scenario: Test MyPush
Given an element by <elem>
When an element is added to the stack
Then the stack should have <elem>

Examples:
|elem|
|9|
	 
Scenario:  Test MyTop empty
When the stack is empty
Then MyTop should throw an exception