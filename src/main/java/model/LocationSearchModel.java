package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationSearchModel {

    @JsonProperty("title")
    private String title;

    @JsonProperty("location_type")
    private String location_type;

    @JsonProperty("woeid")
    private String woeid;

    @JsonProperty("latt_long")
    private String latt_long;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationType() {
        return location_type;
    }

    public void setLocationType(String location_type) {
        this.location_type = location_type;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public String getLattLong() {
        return latt_long;
    }

    public void setLattLong(String latt_long) {
        this.latt_long = latt_long;
    }
}
