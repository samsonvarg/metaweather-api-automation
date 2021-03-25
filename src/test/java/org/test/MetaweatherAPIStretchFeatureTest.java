package org.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MetaweatherAPIStretchFeatureTest {

    @Test
    public void getWeatherDetails() {

        try (InputStream input = new FileInputStream("src/main/resources/metadata-weather.properties")) {

            Properties properties = new Properties();

            // Load a properties file
            properties.load(input);

            // Get the property value and print it out
            String date = properties.getProperty("invalid_test_date");
            System.out.println("Date to test : " + date);

            // Assuming we are testing for Nottingham, which has woeid 30720
            RestAssured.baseURI = "https://www.metaweather.com/api/location/30720/";

            Response locationDayWeatherResponse = RestAssured.given().contentType("application/json\r\n").when()
                    .request(Method.GET, "" + date);

            // Server returns 500 status code for an invalid date param
            // Ideally it should return a response to the user indicating the date input is invalid.
            System.out.println("Location Weather Response Status Code: " + locationDayWeatherResponse.getStatusCode());


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
