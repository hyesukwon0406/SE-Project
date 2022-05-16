package com.hyesuhandh.dasoni.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hyesuhandh.dasoni.databinding.ActivityFindPwBinding;

public class FindPwActivity extends AppCompatActivity {
    private ActivityFindPwBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindPwBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}