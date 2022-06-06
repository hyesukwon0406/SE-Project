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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hyesuhandh.dasoni.Model.UserAccount;
import com.hyesuhandh.dasoni.databinding.ActivityJoinActiityBinding;

import java.text.SimpleDateFormat;
import java.util.Date;


public class JoinActiity extends AppCompatActivity {
    boolean isemailck;
    private ActivityJoinActiityBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();//파이어 베이스 인증
    private DatabaseReference databaseReference = firebaseDatabase.getReference("Dasoni");//실시간 데이터베이스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        binding = ActivityJoinActiityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        isemailck = false;
        binding.joinokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { signUp(); }
        });
        binding.emailjoinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailck();
            }
        });
    }
    //회원가입
    private void signUp(){
        String name = (binding.namefild).getText().toString().trim();//이름
        String email = (binding.emailfild).getText().toString().trim();//이메일
        String password = (binding.pwlyfild).getText().toString().trim();
        String pwcheck = (binding.okpwlyfild).getText().toString().trim();
        if(name.length()>0 &&password.length()>0&&pwcheck.length()>0){
            if(password.equals(pwcheck)){
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(JoinActiity.this, new OnCompleteListener<AuthResult>(){

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    dbuser();
                                    Toast.makeText(JoinActiity.this,"등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(JoinActiity.this,LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(JoinActiity.this,"등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            }
                        });
            }
            else{
                Toast.makeText(JoinActiity.this,"비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show();
            };

        }
        else {
            Toast.makeText(JoinActiity.this,"빈칸을 채워주세요", Toast.LENGTH_SHORT).show();
        }

    }
    //유저db저장
    public void dbuser(){
        FirebaseUser firebaseUser = auth.getCurrentUser();

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");

        String getTime = sdf.format(date);


        String email = (binding.emailfild).getText().toString().trim();//이메일
        String user = email;
        String name = (binding.namefild).getText().toString().trim();//이름
        UserAccount account = new UserAccount();
        account.setNickname(name);
        account.setEmail(firebaseUser.getEmail());
        account.setDateTime(getTime);
        account.setEmoji(1);

        //setValue :database에 insert (삽입) 행위
        databaseReference.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
    }
    /* databaseReference.addListenerForSingleValueEvent(checkRegister);*/


    //중복확인
    public void emailck(){
        String email = (binding.emailfild).getText().toString().trim();//이메일

        if(binding.emailfild.length()>0){
            Query query= databaseReference.child("UserAccount").orderByChild("email").equalTo(email);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        UserAccount userAccount = snapshot1.getValue(UserAccount.class);
                        String yuemail = userAccount.getEmail();
                        if(email.equals(yuemail)){
                            Toast.makeText(JoinActiity.this,"이미 있는 이메일 입니다.", Toast.LENGTH_SHORT).show();
                            return;
                        }else {
                            Toast.makeText(JoinActiity.this,"사용가능한 이메일 입니다.", Toast.LENGTH_SHORT).show();
                            isemailck = true;
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(JoinActiity.this,"데이터베이스  검색 에러.", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(JoinActiity.this,"이메일을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}