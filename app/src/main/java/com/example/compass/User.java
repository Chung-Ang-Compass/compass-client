package com.example.compass;

public class User {
    private String email;
    private String pwd;
    private String userNick;
    private String userName;

    private String tourPlan;
    private String selfIntroduction;
    private String travelTheme;
    private User currentTravelCompanyUser;

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public String getTravelTheme() {
        return travelTheme;
    }

    public String getTourPlan() {
        return tourPlan;
    }

    public User getCurrentTravelCompanyUser() {
        return currentTravelCompanyUser;
    }

    public void setCurrentTravelCompanyUser(User currentTravelCompanyUser) {
        this.currentTravelCompanyUser = currentTravelCompanyUser;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public void setTourPlan(String tourPlan) {
        this.tourPlan = tourPlan;
    }

    public void setTravelTheme(String travelTheme) {
        this.travelTheme = travelTheme;
    }
}
