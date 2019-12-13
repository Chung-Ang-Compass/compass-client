package com.example.compass;

import com.google.gson.annotations.SerializedName;

public class GuidesData {

    @SerializedName("requestNumber")
    int requestNumber;

    public  GuidesData(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }
}
