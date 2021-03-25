package model;

import java.util.Date;

public class LocationWeatherResponseModel {

    private long id;
    private String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass;
    private Date created;
    private Date applicable_date;
    private int min_temp;
    private int max_temp;
    private int the_temp;
    private float wind_speed;
    private float wind_direction;
    private float air_pressure;
    private float humidity;
    private float visibility;
    private int predictability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(Date applicable_date) {
        this.applicable_date = applicable_date;
    }

    public int getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(int min_temp) {
        this.min_temp = min_temp;
    }

    public int getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(int max_temp) {
        this.max_temp = max_temp;
    }

    public int getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(int the_temp) {
        this.the_temp = the_temp;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(float wind_direction) {
        this.wind_direction = wind_direction;
    }

    public float getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(float air_pressure) {
        this.air_pressure = air_pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }

    @Override
    public String toString() {
        return "LocationWeatherResponseModel{" +
                "id=" + id +
                ", weather_state_name='" + weather_state_name + '\'' +
                ", weather_state_abbr='" + weather_state_abbr + '\'' +
                ", wind_direction_compass='" + wind_direction_compass + '\'' +
                ", created=" + created +
                ", applicable_date=" + applicable_date +
                ", min_temp=" + min_temp +
                ", max_temp=" + max_temp +
                ", the_temp=" + the_temp +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", air_pressure=" + air_pressure +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", predictability=" + predictability +
                '}';
    }
}
