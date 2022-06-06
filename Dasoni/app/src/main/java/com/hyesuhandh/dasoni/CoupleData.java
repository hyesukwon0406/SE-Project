package com.hyesuhandh.dasoni;

//커플 정보 모델 클래스
public class CoupleData {
    private int coupleNumber;
    private String userEmail1;
    private String userEmail2;
    private String startDate;
    private int coupleState = 0; //0 = 연결 안 됨, 1 = 수락, 2 = 거절

    public CoupleData(){ } //Default Constructor

    public int getCoupleNumber() {
        return coupleNumber;
    }

    public void setCoupleNumber(int coupNum) {
        this.coupleNumber = coupNum;
    }

    public String getUserEmail1() {
        return userEmail1;
    }

    public void setUserEmail1(String usrEmail1) {
        this.userEmail1 = usrEmail1;
    }

    public String getUserEmail2() {
        return userEmail2;
    }

    public void setUserEmail2(String usrEmail2) {
        this.userEmail2 = usrEmail2;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String strtDate) {
        this.startDate = strtDate;
    }

    public int getCoupleState() {
        return coupleState;
    }

    public void setCoupleState(int coupStat) {
        coupleState = coupStat;
    }
}
