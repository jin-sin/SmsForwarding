package com.abercompany.smsforwarding.model;

import com.google.gson.annotations.SerializedName;

public class GetCheckInListResult {

    @SerializedName("result")
    private String result;

    @SerializedName("message")
    private CheckInList checkInsList;

    public String getResult() {
        return result;
    }
    public CheckInList getCheckInsList() {
        return checkInsList;
    }
}
