package com.hyesuhandh.dasoni;

import java.util.HashMap;
import java.util.Map;

//사용자 계정 정보 모델 클래스
public class UserAccount {
    private  String DateTime; //회원가입 시간
    private  String nickname; //닉네임
    private  String email; //이메일
    private int emoji; //표정[기분 상태]

    public UserAccount(){ } // Default constructor required for calls to DataSnapshot.getValue(UserAccount.class)

    public UserAccount(String dateTime, String nickname, String email, int emoji){ //값들 받아서 생성하는 생성자
        this.DateTime = dateTime;
        this.nickname = nickname;
        this.email = email;
        this.emoji = emoji;
    }

    public int getEmoji() {
        return emoji;
    }

    public void setEmoji(int emoji) {
        this.emoji = emoji;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("dateTime", this.DateTime);
        result.put("email", this.email);
        result.put("emoji", this.emoji);
        result.put("nickname", this.nickname);

        return result;
    }
}
