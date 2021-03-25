package org.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import model.LocationSearchModel;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MetaweatherAPITest {

    @Test
    public void getWeatherDetails() {

        try (InputStream input = new FileInputStream("src/main/resources/metadata-weather.properties")) {

            Properties properties = new Properties();

            // Load a properties file
            properties.load(input);

            // Get the property value and print it out
            String city = properties.getProperty("city");
            System.out.println("City : " + city);

            // Test API for location search to retrieve the Where-On-Earth ID (woeid)
            RestAssured.baseURI = "https://www.metaweather.com/api/location/search/";
            Response locationResponse = RestAssured.given().contentType("application/json\r\n")
                    .when().request(Method.GET, "?query=" + city);

            // Retrieve the response and store the response in a POJO model class
            List<LocationSearchModel> locationSearchResponseList = Arrays.asList(locationResponse.getBody().as(LocationSearchModel[].class));
            LocationSearchModel locationSearchResponse = locationSearchResponseList.get(0);
            System.out.println("Location Search Response woeId for " + city + " is => " + locationSearchResponse.getWoeid());

            RestAssured.baseURI = "https://www.metaweather.com/api/location/";

            // Calculation of date based on value in properties file
            String tomorrowDateFormatParam;
            if (!properties.getProperty("date").trim().contentEquals("")) {
                tomorrowDateFormatParam = properties.getProperty("date");
            } else {
                LocalDate localDate = LocalDate.now().plusDays(1);
                tomorrowDateFormatParam = String.valueOf(localDate.getYear()).concat("/")
                        .concat(String.valueOf(localDate.getMonthValue())).concat("/")
                        .concat(String.valueOf(localDate.getDayOfMonth())).concat("/");
            }

            System.out.println("Date Param for which the weather details is being fetched: " + tomorrowDateFormatParam);

            // Test API for location day search to retrieve the weather details for a given city and particular date
            Response locationWeatherResponse = RestAssured.given().contentType("application/json\r\n").when()
                    .request(Method.GET, "" + locationSearchResponse.getWoeid().concat("/").concat(tomorrowDateFormatParam));

            // Write the response to a JSON file for better readability.
            FileWriter file = null;
            try {
                // Constructs a FileWriter given a file name, using the platform's default charset
                file = new FileWriter("WeatherJsonOutput.json");
                System.out.println("Location Weather Response : ");
                // Print weather details on console and write to file
                file.write(locationWeatherResponse.getBody().prettyPrint());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if( file != null) {
                        file.flush();
                        file.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
