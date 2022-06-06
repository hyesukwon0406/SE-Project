package com.hyesuhandh.dasoni.Model;

public class MemoModel {
    private int memoNumber;
    private int coupleNumber;
    private String dateTime;
    private String memoContent;


    public MemoModel(){ }

    public int getMemoNumber() {
        return memoNumber;
    }

    public void setMemoNumber(int memoNumber) {
        this.memoNumber = memoNumber;
    }

    public int getCoupleNumber() {
        return coupleNumber;
    }

    public void setCoupleNumber(int coupleNumber) {
        this.coupleNumber = coupleNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }
}
