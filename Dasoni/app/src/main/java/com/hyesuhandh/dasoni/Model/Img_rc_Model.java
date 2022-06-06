package com.hyesuhandh.dasoni.Model;

import android.net.Uri;

public class Img_rc_Model {
    private String user;
    private String coupleId;
    private String date;
    private String image;

    public Img_rc_Model(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCoupleId() {
        return coupleId;
    }

    public void setCoupleId(String coupleId) {
        this.coupleId = coupleId;
    }
}
