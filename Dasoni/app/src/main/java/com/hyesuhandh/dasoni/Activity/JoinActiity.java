package com.hyesuhandh.dasoni.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hyesuhandh.dasoni.databinding.ActivityJoinActiityBinding;

public class JoinActiity extends AppCompatActivity {
    private ActivityJoinActiityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinActiityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}