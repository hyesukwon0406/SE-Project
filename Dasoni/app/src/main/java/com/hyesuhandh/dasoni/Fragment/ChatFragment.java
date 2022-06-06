package com.hyesuhandh.dasoni.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
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
import com.hyesuhandh.dasoni.databinding.FragmentChatBinding;

public class ChatFragment extends Fragment {
    private String UserUid;

    private FragmentChatBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //DB 선언 및 할당[생성]
    private DatabaseReference databaseReference = firebaseDatabase.getReference("message"); // 해당 DB 아래에 message가 없으니 만듦

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}