package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyesuhandh.dasoni.databinding.ActivityJoinActiityBinding;
import java.util.HashMap;
import java.util.Map;
public class JoinActiity extends AppCompatActivity {
    private ActivityJoinActiityBinding binding;
    private FirebaseAuth auth;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();//파이어 베이스 인증
    private DatabaseReference databaseReference = firebaseDatabase.getReference();//실시간 데이터베이스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        binding = ActivityJoinActiityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.joinokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
        binding.emailjoinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailck();
            }
        });
    }
    private void signUp(){
        String name = (binding.namefild).getText().toString().trim();
        String email = (binding.emailfild).getText().toString().trim();
        String password = (binding.pwlyfild).getText().toString().trim();
        String pwcheck = (binding.okpwlyfild).getText().toString().trim();
        if(name.length()>0 &&password.length()>0&&pwcheck.length()>0){
            if(password.equals(pwcheck)){
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(JoinActiity.this, new OnCompleteListener<AuthResult>(){

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(JoinActiity.this,LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(JoinActiity.this,"등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            }
                        });
            };

        }

    }
    public void emailck(){
        String email = (binding.emailfild).getText().toString().trim();
        if(binding.emailfild.length()>0){
            auth.sendSignInLinkToEmail(email, ActionCodeSettings.newBuilder().build())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(JoinActiity.this,"인증메일을 보냈습니다.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(JoinActiity.this,"오류 발생", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
        }else{
            Toast.makeText(JoinActiity.this,"이메일을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}