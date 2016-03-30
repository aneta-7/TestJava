Scenario:  Test add
Given a variable x by value <x>
Given a variable y by value <y>
Then add should be equal <add>

Examples:
|x|y|add|
|2|4|6|
|3|5|6|
|4|12|15|

Scenario: Test sub
Given a variable x by value <x>
Given a variable y by value <y>
Then sub should be equal <sub>

Examples:
|x|y|sub|
|4|1|5|
|7|5|2|
|20|12|8|

Scenario: Test mul
Given a variable x by value <x>
Given a variable y by value <y>
Then mul should be equal <mul>

Examples:
|x|y|mul|
|2|4|8|
|3|5|15|
|4|0|0|

Scenario: Test div
Given a variable x by value <x>
Given a variable y by value <y>
Then div should be equal <div>

Examples:
|x|y|div|
|4|1|4|
|6|3|2|
|4|0|0|


 