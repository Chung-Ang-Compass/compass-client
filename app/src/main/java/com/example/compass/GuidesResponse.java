package com.example.compass;

import com.google.gson.annotations.SerializedName;

public class GuidesResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("guideName")
    private String guideName;

    @SerializedName("country")
    private String country;

    @SerializedName("city")
    private String city;

    @SerializedName("theme")
    private String theme;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getTheme() {
        return theme;
    }

    public String getGuideName() {
        return guideName;
    }
}
