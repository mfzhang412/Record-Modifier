# Record-Modifier

How to run: Run ModifyRecords.class located in 'bin' folder. To run, open command prompt, navigate to the 'bin' folder and type 'java ModifyRecords'. To navigate to the 'bin' folder from command prompt, copy the directory from your computer, and type 'cd ' and then the copied file directory, then hit 'enter'.

Description: The user selects a .txt or .csv file they wish to modify records for. The modifications are as follows: for each line in the .txt or .csv file, that line gets duplicated with a number following that line from 1 to 9999.

Example:

Original .txt or .csv file ---

Doe, John

Roe, Richard@

Doe, Jane5
____________________________________________________

Modified .txt or .csv file ---

Doe, John1

Doe, John2

...

Doe, John9999

Roe, Richard@1

Roe, Richard@2

...

Roe, Richard@9999

Doe, Jane51

Doe, Jane52

...

Doe, Jane59999

