package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;

public class StoreRecord extends AppCompatActivity {
    EditText storeHeart,storeSys,storeDya,storePhn,storeDate,storeTime;
    Button storeBtn;
    DatabaseReference reff;
    DatePicker datePicker;
    Calendar calendar;
    long maxID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_record);
        storeHeart=findViewById(R.id.store_heart);
        storeSys=findViewById(R.id.store_systolic);
        storeDya=findViewById(R.id.store_dyastolic);
        storeBtn=findViewById(R.id.store_btn);
        storeTime=findViewById(R.id.store_time);
        storeDate=findViewById(R.id.store_date);
        reff= FirebaseDatabase.getInstance().getReferenceFromUrl("https://cardiacproject-d7850-default-rtdb.firebaseio.com/");
        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String heart=storeHeart.getText().toString();
                final String systolic=storeSys.getText().toString();
                final String dyastolic=storeDya.getText().toString();
                final String date=storeDate.getText().toString();
                final String time=storeTime.getText().toString();
                final String date1=storeDate.getText().toString().trim();
                final String time1=storeDate.getText().toString().trim();
                final String childKey=reff.push().getKey();;



               // int day=datePicker.getDayOfMonth();
               // int month=datePicker.getMonth();
                //int year=datePicker.getYear();
                //String date=day+"/"+month+"/"+year;
                //int hour = calendar.get(Calendar.HOUR_OF_DAY);
                //int minute = calendar.get(Calendar.MINUTE);
                //final String time=hour + ":" + minute;

                reff.child("Record").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {




                            reff.child("Record").child(childKey).child("date").setValue(date);
                            reff.child("Record").child(childKey).child("time").setValue(time);
                            reff.child("Record").child(childKey).child("heart").setValue(heart);
                            reff.child("Record").child(childKey).child("systolic").setValue(systolic);
                            reff.child("Record").child(childKey).child("dyastolic").setValue(dyastolic);
                            reff.child("Record").child(childKey).child("childKey").setValue(childKey);

                            if((Integer.parseInt(systolic)>=90&&Integer.parseInt(systolic)<=140) && (Integer.parseInt(dyastolic)<=60 && Integer.parseInt(dyastolic)<=90))
                            {
                                reff.child("Record").child(childKey).child("comment").setValue("Fit");
                            }
                            else
                            {
                                reff.child("Record").child(childKey).child("comment").setValue("Pressure Not Normal");
                            }
                            Toast.makeText(StoreRecord.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                            finish();


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}