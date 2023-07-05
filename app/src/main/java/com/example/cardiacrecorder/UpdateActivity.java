package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {
    EditText updateHeart, updateSys, updateDya,updateDate,updateTime ;
    Button updateBtn;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateHeart = findViewById(R.id.update_heart);
        updateSys = findViewById(R.id.update_systolic);
        updateDya = findViewById(R.id.update_dyastolic);
        updateDate = findViewById(R.id.update_date);
        updateTime = findViewById(R.id.update_time);

        updateBtn = findViewById(R.id.update_btn);


        reff = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacproject-d7850-default-rtdb.firebaseio.com/");
        // Retrieve the childKey from the previous activity (StoreRecord) using Intent
        Intent intent = getIntent();
        final String childKey = intent.getStringExtra("childKey");

        // Retrieve the existing data from Firebase based on the childKey
       reff.child("Record").child(childKey).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Retrieve the data and populate the UI elements
                String heart = snapshot.child("heart").getValue(String.class);
                String systolic = snapshot.child("systolic").getValue(String.class);
                String dyastolic = snapshot.child("dyastolic").getValue(String.class);
                String Date = snapshot.child("date").getValue(String.class);
                String Time = snapshot.child("time").getValue(String.class);
                updateHeart.setText(heart);
                updateSys.setText(systolic);
                updateDya.setText(dyastolic);
                updateDate.setText(Date);
                updateTime.setText(Time);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedHeart = updateHeart.getText().toString();
                String updatedSys = updateSys.getText().toString();
                String updatedDya = updateDya.getText().toString();
                String updatedDate = updateDate.getText().toString();
                String updatedTime = updateTime.getText().toString();

                // Update the values in Firebase
                reff.child("Record").child(childKey).child("heart").setValue(updatedHeart);
                reff.child("Record").child(childKey).child("systolic").setValue(updatedSys);
                reff.child("Record").child(childKey).child("dyastolic").setValue(updatedDya);
                reff.child("Record").child(childKey).child("date").setValue(updatedDate);
                reff.child("Record").child(childKey).child("time").setValue( updatedTime);

                Toast.makeText(UpdateActivity.this, "Record Updated Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}