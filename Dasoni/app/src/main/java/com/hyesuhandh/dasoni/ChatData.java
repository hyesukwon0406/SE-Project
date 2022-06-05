package com.hyesuhandh.dasoni;

import java.io.Serializable; // importing this for chat instance structure
import com.hyesuhandh.dasoni.UserAccount;

public class ChatData implements Serializable{
    private String msg;
    private String nickname;

    public ChatData(){ // default constructor
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
}
