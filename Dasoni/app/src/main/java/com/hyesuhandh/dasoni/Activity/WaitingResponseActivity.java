package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyesuhandh.dasoni.R;
import com.hyesuhandh.dasoni.UserAccount;
import com.hyesuhandh.dasoni.databinding.ActivityWaitingResponseBinding;

public class WaitingResponseActivity extends AppCompatActivity {
    private ActivityWaitingResponseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaitingResponseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //상대방 응답 확인 후 아래의 수락/거절 경우를 if else문으로 작성
        if(true) { //요청 수락시 - 응답 확인해서 수락인 경우
            requestAccepted();
        }
        else { //요청 거절시 - 응답 확인해서 거절인 경우
            try {
                requestRefused();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestAccepted(){ //수락시 커플 메인 화면으로 전환
        Intent intent = new Intent(this, MainActivity.class);

        Toast.makeText(getApplicationContext(), "커플 연결이 완료되었습니다.\n메인 화면으로 전환합니다.", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    public void requestRefused() throws InterruptedException { //거절시 다시 연결 화면으로 전환
        //거절 알림 띄움
        Toast.makeText(getApplicationContext(), "상대방이 요청을 거절했습니다.\n회원 연결 화면으로 돌아갑니다.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, UserConnectionActivity.class);
        startActivity(intent);
    }
}