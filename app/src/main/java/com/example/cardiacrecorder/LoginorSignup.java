package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginorSignup extends AppCompatActivity implements View.OnClickListener {
    private Button signUp;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginor_signup);

        signUp = findViewById(R.id.signUp);
        signIn = findViewById(R.id.signIn);

        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUp:
                startActivity(new Intent(LoginorSignup.this, SignUpActivity.class));
                break;
            case R.id.signIn:
                startActivity(new Intent(LoginorSignup.this, login.class));
                break;
        }

    }
}