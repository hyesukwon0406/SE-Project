package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyesuhandh.dasoni.databinding.ActivityUserConnectionBinding;

public class UserConnectionActivity extends AppCompatActivity {
    private ActivityUserConnectionBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserConnectionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

        binding.findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //입력된 아이디의 유저에게 커플 요청 보내기 - 해당 응답은 응답대기 화면에서 받음
                if(binding.finddasoniinputtxt.length() > 0 ){
                    String id = binding.finddasoniinputtxt.getText().toString().trim(); //입력된 아이디를 가져옴

                    //여기서 이제 해당 유저에게 커플 요청 보내기 - 근데 어케 하누...?;;

                    openWaitingResponseActivity(); //커플 수락 대기 화면 전환
                }
                else { //아이디가 입력되지 않은 경우
                    Toast.makeText(getApplicationContext(), "아이디를 입력하셔야 합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openWaitingResponseActivity(){
        //change to waiting response activity.
        Intent intent = new Intent(this, WaitingResponseActivity.class);
        startActivity(intent);
    }
}