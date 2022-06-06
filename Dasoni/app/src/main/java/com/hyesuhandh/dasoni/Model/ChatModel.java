package com.hyesuhandh.dasoni.Model;

import java.io.Serializable; // importing this for chat instance structure


//채팅 정보 모델 클래스
public class ChatModel implements Serializable{
    private String msg;
    private String nickname;
    private String DateTime;

    public ChatModel(){ // default constructor
        }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
