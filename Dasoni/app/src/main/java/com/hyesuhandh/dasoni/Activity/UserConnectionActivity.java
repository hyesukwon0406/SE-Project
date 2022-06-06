package com.hyesuhandh.dasoni.Activity;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.hyesuhandh.dasoni.UserAccount;
import com.hyesuhandh.dasoni.databinding.ActivityUserConnectionBinding;

public class UserConnectionActivity extends AppCompatActivity {
    private static final String TAG = "UserConnectionActivity";

    private ActivityUserConnectionBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance(); //DB 선언 및 할당[생성]
    private DatabaseReference dasoniRef = firebaseDB.getReference("Dasoni"); // 실시간 DB
    private DatabaseReference usrAcctRef = firebaseDB.getReference("Dasoni/UserAccount"); // 실시간 DB
    private String currentUID;
    private String userEmailAsId;

//    ValueEventListener usrAcctListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) { //DB에 존재하는 모든 UID와 value를 형태 그대로 가져 옴
//
//        }
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//            // Getting Post failed, log a message
//            Log.w(TAG, "다소니 찾기 오류", databaseError.toException());
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityUserConnectionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();

//        this.usrAcctRef.addValueEventListener(usrAcctListener);
        FirebaseUser currentUser = auth.getCurrentUser(); //현재 사용자 정보 가져옴
        currentUID = usrAcctRef.child(currentUser.getUid()).toString(); //현재 UID를 가져와 문자열로 저장

        binding.findbutton.setOnClickListener(new View.OnClickListener() { //찾기 버튼 클릭 시
            @Override
            public void onClick(View view) { //입력된 아이디의 유저에게 커플 요청 보내기
                if(binding.finddasoniinputtxt.length() > 0 ){ //아이디가 입력된 경우
                    userEmailAsId = binding.finddasoniinputtxt.getText().toString().trim(); //입력된 아이디를 가져옴

                    //1.가져온 아이디가 DB에 있는지 확인해서
                    String tmp = usrAcctRef.getKey();
                    System.out.println(tmp);
                    //2.(if)있으면 해당 유저와 상태 0[연결 안 됨]인 CoupleData 생성  커플 요청

                    //2-1.waiting_response로 화면 전환하기
                    openWaitingResponseActivity(); //커플 수락 대기 화면 전환

                    //2-2.(else)없으면 없는 아이디를 입력했다고 하고, 다시 입력받게 함

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