package com.hyesuhandh.dasoni.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hyesuhandh.dasoni.databinding.ActivityIdpwFindBinding;

public class IdpwFindActivity extends AppCompatActivity {
    private ActivityIdpwFindBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIdpwFindBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}