Feature: Gmail login
Scenario Outline: validate password

Given launch gmail site
When enter userid with "tushar.rajput774" value
And click next button
And enter password with "<p>" value
And click password next button
Then validate password with "<pc>" criteria
And close site

Examples:
|           p              |       pc      |
|  nokia5233ebay           |   valid       |
|  admin123                |   invalid     |
|                          |   blank       |