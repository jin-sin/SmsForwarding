package com.abercompany.smsforwarding.model;

import com.google.gson.annotations.SerializedName;

public class CheckOut {

    @SerializedName("room_num")
    private String roomNum;

    @SerializedName("name")
    private String name;

    @SerializedName("elec_gas")
    private Boolean elecGas;

    @SerializedName("out_date")
    private Boolean outDate;

    @SerializedName("remote_con")
    private Boolean remoteCon;

    @SerializedName("account")
    private Boolean account;

    @SerializedName("katok")
    private Boolean katok;

    @SerializedName("tv")
    private Boolean tv;

    public String getRoomNum() {
        return roomNum;
    }
    public String getName() {
        return name;
    }
    public Boolean getElecGas() {
        return elecGas;
    }
    public Boolean getOutDate() {
        return outDate;
    }
    public Boolean getRemoteCon() {
        return remoteCon;
    }
    public Boolean getAccount() {
        return account;
    }
    public Boolean getKatok() {
        return katok;
    }
    public Boolean getTv() {
        return tv;
    }
}
