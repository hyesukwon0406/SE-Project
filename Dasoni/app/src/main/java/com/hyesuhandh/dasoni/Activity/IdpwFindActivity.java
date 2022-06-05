package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyesuhandh.dasoni.databinding.ActivityFindPwBinding;

public class IdpwFindActivity extends AppCompatActivity {
    private ActivityFindPwBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindPwBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(binding.emailfindlayfild.length()>0){
//                    pwreset();
//                }else{
//                    Toast.makeText(IdpwFindActivity.this, "이메일을 입력해 주세요", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    //비밀번호 재설정
    public void pwreset(){
//        String email = binding.emailfindlayfild.getText().toString().trim();
//        auth.sendPasswordResetEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(IdpwFindActivity.this, "이메일을 보냈습니다.", Toast.LENGTH_LONG).show();
//                            finish();
//                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//                        }else{
//                            Toast.makeText(IdpwFindActivity.this, "메일 보내기 실패!", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
    }
}