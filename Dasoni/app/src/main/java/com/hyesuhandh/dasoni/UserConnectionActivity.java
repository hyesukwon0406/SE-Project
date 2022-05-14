package com.hyesuhandh.dasoni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserConnectionActivity extends AppCompatActivity {
    private Button findDasoniButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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