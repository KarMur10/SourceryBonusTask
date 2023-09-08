## Task

Implement a method that prints all dates between two given years that remains the same, if numbers of the date are reversed.

## Solution

In order to solve this task by finding all dates that remain the same if numbers are reversed, different logic must be applied based on the number of digits in the provided year.

### Years consisting of 4 or 5 digits

If provided years consist of 4 or 5 digits there's a maximum of 1 possible date per year. This date can be found by mirroring the order of the first 4 digits of the year as the digits for month and day. It is then necessary to check if such a date exists. To accomplish this SimpleDateFormat is used.

### Years consisting of 6 or more digits

If provided years consist of 6 or more digits there's also only a maximum of 1 possible date per year. However, most years are easy to discard, because if all the digits after the first 4 are not a palindrome, the year has no dates that fit the requirement.

### Years consisting of less than 4 digits

Unfortunately, there are separate rules for every number of digits below 4.

#### 1 digit years:

All 1 digit years have multiple dates that fit the requirement. To find them, different possible dates are constructed where the first digits of the month and day must be the same and can either be the numbers 0 or 1. While the second digit of the month can be any number between 0, 1, and 2. Every date constructed according to these rules is then checked if exists, and if so, is printed.

#### 2 digit years:

All 2 digit years have only 1 possible date that fits the requirement. This date can be constructed by inverting the year number for the day of the date and setting the month of the date as 11. A date constructed this way is then checked if exists (with SimpleDateFormat), and if so, is printed.

#### 3 digit years:

3 digit years are checked similarly to 1 digit years, but the only alternating digit is the first digit of the month (and can only alternate between 0 and 1) as the remaining digits of month and day are obtained by inverting the digits of the year. And unlike 1 digit years, not every 3 digit year has a date that fits the requirement.