package com.hyesuhandh.dasoni.Model;



//사용자 계정 정보 모델 클래스
public class UserAccount {
    private  String DateTime;// 회원가입 시간
    private  String nickname;// 닉네임
    private  String email;//이메일
    private int emoji;// 표정?


    public UserAccount(){ }


    public int getEmoji() { return emoji; }

    public void setEmoji(int emoji) { this.emoji = emoji; }

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

}
