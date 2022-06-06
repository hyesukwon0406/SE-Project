package com.hyesuhandh.dasoni.Activity;

import static androidx.constraintlayout.widget.ConstraintSet.VISIBLE;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class UserConnectionActivity extends AppCompatActivity {
    private static final String TAG = "UserConnectionActivity";
    private String UserUid;
    private String Useremail;
    private String dasonip;
    private Button findDasoniButton;
    private TextView showText;
    private EditText pfinddasoniinputtxt;
    private ActivityUserConnectionBinding binding;
    private FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance(); //DB 선언 및 할당[생성]
    private DatabaseReference dasoniRef = firebaseDB.getReference("Dasoni"); // 실시간 DB
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserUid = getIntent().getStringExtra("UserUid");
        Useremail = getIntent().getStringExtra("Useremail");
        ChatFragment cfm = new ChatFragment();
        CoupleMainFragment cpfm = new CoupleMainFragment();
        GalleryFragment gfm = new GalleryFragment();
        MemoBoardFragment mfm = new MemoBoardFragment();
        binding = ActivityUserConnectionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        findDasoniButton = (Button) findViewById(R.id.findbutton);
        pfinddasoniinputtxt = (EditText) findViewById(R.id.finddasoniinputtxt);
        showText = (TextView) findViewById(R.id.finddasonitext);
        Bundle bundle = new Bundle();
        bundle.putString("UserUid",UserUid);
        cfm.setArguments(bundle);
        cpfm.setArguments(bundle);
        gfm.setArguments(bundle);
        mfm.setArguments(bundle);
        dasonist();
        dasonirequest();
        findDasoniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String dasonipartner = pfinddasoniinputtxt.getText().toString().trim();//이메일
                Toast.makeText(UserConnectionActivity.this,pfinddasoniinputtxt.getText().toString().trim(), Toast.LENGTH_LONG).show();
                if(dasonipartner.length()>0&&!dasonipartner.equals(Useremail)){
                    Query queries=dasoniRef.child("UserAccount").orderByChild("email").equalTo(dasonipartner);
                    if(dasonipartner.length()>0) {
                        queries.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                    UserAccount userAccount = snapshot1.getValue(UserAccount.class);
                                    dasonip = userAccount.getEmail();
                                    if (dasonip.length() > 0) {
                                        CoupleModel cm = new CoupleModel();
                                        cm.setUserEmail1(Useremail);
                                        cm.setGetUserEmail2(dasonip);
                                        cm.setRequestState(0);
                                        dasoniRef.child("CoupleData").push().setValue(cm);
                                        showText.setText("다소니의 승낙을 \n       대기중");
                                    } else {
                                        Toast.makeText(UserConnectionActivity.this, "없는 이메일을 입니다", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                    }else {}

                }else{
                        Toast.makeText(UserConnectionActivity.this,"상대방 이메일을 입력해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query queries=dasoniRef.child("CoupleData").orderByChild("getUserEmail2").equalTo(Useremail);
                queries.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            CoupleModel coupleModel = snapshot1.getValue(CoupleModel.class);
                            coupleModel.setRequestState(1);
                            Map<String, Object>  update = new HashMap<String,Object>();
                            update.put("requestState",coupleModel.getRequestState());
                            update.put("getUserEmail2",coupleModel.getGetUserEmail2());
                            update.put("userEmail1",coupleModel.getUserEmail1());
                            dasoniRef.child("CoupleData").updateChildren(update);
                            binding.cardv.setVisibility(View.INVISIBLE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) { }
                });
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query queries=dasoniRef.child("CoupleData").orderByChild("getUserEmail2").equalTo(Useremail);
                queries.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            CoupleModel coupleModel = snapshot1.getValue(CoupleModel.class);
                            coupleModel.setRequestState(2);
                            Map<String, Object>  update = new HashMap<String,Object>();
                            update.put("requestState",coupleModel.getRequestState());
                            update.put("getUserEmail2",coupleModel.getGetUserEmail2());
                            update.put("userEmail1",coupleModel.getUserEmail1());
                            dasoniRef.child("CoupleData").updateChildren(update);
                            binding.cardv.setVisibility(View.INVISIBLE);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) { }
                });

            }
        });

    }
    public void dasonirequest(){
        Query queries=dasoniRef.child("CoupleData").orderByChild("getUserEmail2").equalTo(Useremail);
        queries.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    CoupleModel coupleModel = snapshot1.getValue(CoupleModel.class);
                    int a = coupleModel.getRequestState();
                    if (a == 0) {
                        binding.cardv.setVisibility(View.VISIBLE);
                    } else{ }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });


    }
    public void dasonist(){
        Query queries=dasoniRef.child("CoupleData").orderByChild("getUserEmail2").equalTo(Useremail);
        queries.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    CoupleModel coupleModel = snapshot1.getValue(CoupleModel.class);
                    int a = coupleModel.getRequestState();
                    if (a == 1) {
                       openMainActivity();
                    } else{

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Query query=dasoniRef.child("CoupleData").orderByChild("UserEmail1").equalTo(Useremail);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()) {
                    CoupleModel coupleModel = snapshot1.getValue(CoupleModel.class);
                    int a = coupleModel.getRequestState();
                    if (a == 2) {
                        showText.setText("상대방이 요청을 \n     거절했습니다.");
                    } else{

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void openMainActivity(){
        //this handles when the button is clicked.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}