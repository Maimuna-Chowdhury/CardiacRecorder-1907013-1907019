package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    EditText full_name,emaill,pass_word,height1,weight1,phn;
    Button Btn;
    ImageView backbtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        full_name = findViewById(R.id.signupfullname);
        emaill = findViewById(R.id.signupemail);
        pass_word = findViewById(R.id.signuppassword);
        height1 = findViewById(R.id.signupheight);
        weight1 = findViewById(R.id.signupweight);
        phn = findViewById(R.id.signupphone);
        Btn = findViewById(R.id.signupbtn);
        backbtn = findViewById(R.id.signupback);
        mAuth = FirebaseAuth.getInstance();

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.super.onBackPressed();
            }
        });

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emaill.getText().toString().trim();
                String password=pass_word.getText().toString().trim();


                if(email.isEmpty())
                {
                    emaill.setError("Enter an email address");
                    emaill.requestFocus();
                    return;
                }

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emaill.setError("Enter a valid email address");
                    emaill.requestFocus();
                    return;
                }

                //checking the validity of the password
                if(email.isEmpty())
                {
                    emaill.setError("Enter a password");
                    emaill.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }





    }





