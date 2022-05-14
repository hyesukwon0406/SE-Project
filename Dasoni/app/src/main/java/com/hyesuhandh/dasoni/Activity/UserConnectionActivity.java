package com.hyesuhandh.dasoni.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hyesuhandh.dasoni.R;
import com.hyesuhandh.dasoni.databinding.ActivityUserConnectionBinding;

public class UserConnectionActivity extends AppCompatActivity {
    private Button findDasoniButton;
    private ActivityUserConnectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserConnectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_user_connection);

        findDasoniButton = (Button) findViewById(R.id.findbutton);
        findDasoniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity(){
        //this handles when the button is clicked.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}