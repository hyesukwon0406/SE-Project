package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyesuhandh.dasoni.databinding.ActivityWaitingResponseBinding;
import com.hyesuhandh.dasoni.UserAccount;

public class WaitingResponseActivity extends AppCompatActivity {
    private ActivityWaitingResponseBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //DB 선언 및 할당[생성]
    private DatabaseReference databaseReference = firebaseDatabase.getReference("Dasoni");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaitingResponseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

        //상대방 응답 확인 후 아래의 수락/거절 경우를 if else문으로 작성
        if(true) { //응답 확인해서 수락인 경우
            requestAccepted();
        }
        else { //응답 확인해서 거절인 경우
            try {
                requestRefused();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestAccepted(){ //수락 시
        Intent intent = new Intent(this, MainActivity.class);

        //1.CoupleData의 연결 상태를 1절[수락]로 변경

        //2.연결 완료 메세지 띄우고
        Toast.makeText(getApplicationContext(), "커플 연결이 완료되었습니다.\n메인 화면으로 전환합니다.", Toast.LENGTH_LONG).show();

        //3.커플 메인으로 화면 전환

        startActivity(intent);
    }

    public void requestRefused() throws InterruptedException { //거절 시
        Intent intent = new Intent(this, UserConnectionActivity.class);

        //1.CoupleData의 연결 상태를 2[거절]로 변경

        //2.거절 알림 띄움
        Toast.makeText(getApplicationContext(), "상대방이 요청을 거절했습니다.\n회원 연결 화면으로 돌아갑니다.", Toast.LENGTH_LONG).show();

        //3.햬당 CoupleData 객체 삭제

        //4.회원 연결 화면으로 화면 전환
        startActivity(intent);

    }
}