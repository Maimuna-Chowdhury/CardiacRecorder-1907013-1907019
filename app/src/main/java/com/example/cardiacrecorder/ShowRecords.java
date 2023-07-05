package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cardiacrecorder.databinding.ActivityMainBinding;
import com.google.android.material.progressindicator.BaseProgressIndicator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowRecords extends AppCompatActivity {
    ListView listView;
    DatabaseReference reff;
    private List<Record>recordList;
    private CustomRecordAdapter customRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_records);
        listView=findViewById(R.id.record_listView);
        recordList=new ArrayList<>();
        reff= FirebaseDatabase.getInstance().getReference("Record");
        customRecordAdapter=new CustomRecordAdapter(ShowRecords.this,recordList,reff);











    }

    @Override
    protected void onStart() {
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recordList.clear();
                for(DataSnapshot dataSnapshot1:snapshot.getChildren())
                {
                    Record record=dataSnapshot1.getValue(Record.class);
                    recordList.add(record);
                }
                listView.setAdapter(customRecordAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}