**Metaweather API Testing**

This project contains the test classes necessary to test the Metaweather APIs.

Please note that the answers to the QA Challenge Part 2 questions is in the file QA Challenge Part Two Questions.txt

Pre-requistes- 
    
    JAVA JDK
    Maven 

Test Classes

    1. MetaweatherAPITest Class

    This class retrieves tomorrow's weather details for Nottingham. 
    The city and date values are parameterised using a properties file. 
    
    Property city - City for which we want to get the weather details.
    Property date - Date for which we want to get the details. If not set, it will automatically use tomorrow's date. If set, it uses the date param as defined by user.

    The test class prints to console the weather details for Nottingham for the specified date.
    Also the output is written to a file WeatherJsonOutput.json for better readability. The file will be created in the location from where the project is run.

    2. MetaweatherAPIStretchFeatureTest Class

    This class exposes a bug on the Metaweather server. 
    The assumed scenario is that of an invalid date param in the location day API.
    When a user passes an invalid date to the test class, the test returns a 500 server error. 
    
    From a testing perspective, this should be handled in the server to inform the user that the date entered is invalid.
   
Steps for Execution:

    Import project into IDE workspace
    Run Maven clean and package to ensure there are no compilation errors.
    To get the weather details based on city and date parameter combination, right click and run the test class MetaweatherAPITest.
    To run the test which exposes the bug on the API, right click and run the class MetaweatherAPIStretchFeature.
