[![Build Status](https://travis-ci.org/strum07/WeatherApp.svg?branch=master)](https://travis-ci.org/strum07/WeatherApp)



# Install Notes:

1. Clone the repo
2. Import dependencies in the POM
3. Build Project 
4. Run


# Required
1. Please create a txt file in the path (src/main/java/environment) with only your key - File name: Key.txt
2. Save the file

# Input Format
Template: {{City Name}}{{Delimiter}}{{Two Letter Country Code}}
1. Valid Country Codes: 2-letter ISO 3166 country codes
2. Valid City Names: Any of the 200,000 cities served by openweathermap.org
3. Valid Delimiters: Space( ), Comma(,), Dot(.), Forward Slash(/), Semi Colon(;)

Note: Do not worry about the case - It's not case-sensitive.


# Errors/ Exit Codes
1. Exit Status 1 - 404 : Location not found 
2. Exit Status 2 - 500: Internal Sever Error 
3. Exit status 3 - Any other Http error codes - Please try and enter the input in the requested format
4. Exit Status 4 - API file/Key not found. Please refer to note above
5. Exit Status 5 - Can't read key from file/Key invalid



Note:


Test Cases - to Be added. Apologies for not having spent enough time on writing the test cases.
