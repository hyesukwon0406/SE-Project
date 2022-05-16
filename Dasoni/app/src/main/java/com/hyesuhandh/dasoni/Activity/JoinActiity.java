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
import com.hyesuhandh.dasoni.databinding.ActivityJoinActiityBinding;
import java.util.HashMap;
import java.util.Map;
public class JoinActiity extends AppCompatActivity {
    private ActivityJoinActiityBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

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
    }
    private void signUp(){
        final String name = (binding.namefild).getText().toString().trim();
        final String email = (binding.emailfild).getText().toString().trim();
        final String password = (binding.pwlyfild).getText().toString().trim();
        final String pwcheck = (binding.okpwlyfild).getText().toString().trim();
        if(name.length()>0 &&password.length()>0&&pwcheck.length()>0&&email.length()>0){
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
}