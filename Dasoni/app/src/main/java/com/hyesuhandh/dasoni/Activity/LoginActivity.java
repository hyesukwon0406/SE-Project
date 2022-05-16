package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyesuhandh.dasoni.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        //로그인 확인
        binding.okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.Idfild.length()>0){
                    if(binding.Pwfild.length()>0){
                        logIn();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //id/pw 찾기
        binding.findbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, IdpwFindActivity.class);
                startActivity(intent);
            }
        });
        //회원가입
        binding.joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, JoinActiity.class);
                startActivity(intent);
            }
        });

    }
    //로그인 기능
    public void logIn(){
        String email = binding.Idfild.getText().toString().trim();
        String pwd = binding.Pwfild.getText().toString().trim();
        auth.signInWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {//성공했을때
                            Intent intent = new Intent(LoginActivity.this, UserConnectionActivity.class);
                            startActivity(intent);
                        } else {//실패했을때
                            Toast.makeText(LoginActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}