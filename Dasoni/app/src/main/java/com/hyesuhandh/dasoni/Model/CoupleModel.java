package com.hyesuhandh.dasoni.Model;

public class CoupleModel {
    private  String userEmail1;
    private String getUserEmail2;
    private String startDate;
    private int requestState;

    public CoupleModel(){}


    public String getUserEmail1() {
        return userEmail1;
    }

    public void setUserEmail1(String userEmail1) {
        this.userEmail1 = userEmail1;
    }

    public String getGetUserEmail2() {
        return getUserEmail2;
    }

    public void setGetUserEmail2(String getUserEmail2) {
        this.getUserEmail2 = getUserEmail2;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getRequestState() {
        return requestState;
    }

    public void setRequestState(int requestState) {
        this.requestState = requestState;
    }
}
