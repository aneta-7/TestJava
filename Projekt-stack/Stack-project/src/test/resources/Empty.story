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
