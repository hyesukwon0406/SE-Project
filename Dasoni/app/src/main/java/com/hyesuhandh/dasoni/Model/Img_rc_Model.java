package com.hyesuhandh.dasoni.Model;

import android.net.Uri;

public class Img_rc_Model {
    private String user;
    private String date;
    private Uri image;

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

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
