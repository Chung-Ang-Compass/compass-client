package com.example.compass;

public class Guide{
    private String name;
    private String country;
    private String city;
    private String theme;
    private String bailiwick;
    private String career;

    public Guide(String name, String country, String city, String theme, String bailiwick, String career){
        this.name = name;
        this.country = country;
        this.city = city;
        this.theme = theme;
        this.bailiwick = bailiwick;
        this.career = career;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBailiwick(String bailiwick) {
        this.bailiwick = bailiwick;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public String getBailiwick() {
        return bailiwick;
    }

    public String getCareer() {
        return career;
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
}
