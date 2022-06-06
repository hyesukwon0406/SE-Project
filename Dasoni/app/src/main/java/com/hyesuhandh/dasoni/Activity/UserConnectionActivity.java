package com.hyesuhandh.dasoni.Activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hyesuhandh.dasoni.Fragment.ChatFragment;
import com.hyesuhandh.dasoni.Fragment.CoupleMainFragment;
import com.hyesuhandh.dasoni.Fragment.GalleryFragment;
import com.hyesuhandh.dasoni.Fragment.MemoBoardFragment;
import com.hyesuhandh.dasoni.Model.CoupleModel;
import com.hyesuhandh.dasoni.Model.UserAccount;
import com.hyesuhandh.dasoni.R;
import com.hyesuhandh.dasoni.databinding.ActivityUserConnectionBinding;

public class UserConnectionActivity extends AppCompatActivity {
    private static final String TAG = "UserConnectionActivity";
    private String UserUid;
    private String Useremail;
    private String dasonip;
    private ActivityUserConnectionBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance(); //DB 선언 및 할당[생성]
    private DatabaseReference dasoniRef = firebaseDB.getReference("Dasoni"); // 실시간 DB
    private DatabaseReference usrAcctRef = firebaseDB.getReference("Dasoni/UserAccount"); // 실시간 DB

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserUid = getIntent().getStringExtra("UserUid");
        Useremail = getIntent().getStringExtra("Useremail");
        binding = ActivityUserConnectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_user_connection);
        ChatFragment cfm = new ChatFragment();
        CoupleMainFragment cpfm = new CoupleMainFragment();
        GalleryFragment gfm = new GalleryFragment();
        MemoBoardFragment mfm = new MemoBoardFragment();
        binding.findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("UserUid",UserUid);
                cfm.setArguments(bundle);
                cpfm.setArguments(bundle);
                gfm.setArguments(bundle);
                mfm.setArguments(bundle);

                String dasonipartner = (binding.finddasoniinputtxt).getText().toString().trim();//이메일
                Query queries=usrAcctRef.orderByChild("email").equalTo(dasonipartner);
                if(dasonipartner.length()>0){
                    queries.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot snapshot1 : snapshot.getChildren()){
                                UserAccount userAccount = snapshot1.getValue(UserAccount.class);
                                dasonip = userAccount.getEmail();
                            }
                            if(dasonip.length()>0){
                                CoupleModel cm = new CoupleModel();
                                cm.setUserEmail1(Useremail);
                                cm.setUserEmail2(dasonip);
                                cm.setRequestState(0);
                                dasoniRef.child("CoupleData").push().setValue(cm);
                            }else{
                                Toast.makeText(UserConnectionActivity.this,"없는 이메일을 입니다", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }else {
                    Toast.makeText(UserConnectionActivity.this,"상대방 이메일을 입력해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void openMainActivity(){
        //this handles when the button is clicked.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}