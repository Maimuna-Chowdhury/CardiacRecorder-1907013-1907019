package com.example.cardiacrecorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.List;

public class CustomRecordAdapter extends ArrayAdapter<Record> {

    private Activity context;
    private List<Record> recordList;
    private DatabaseReference databaseRef;

    public CustomRecordAdapter(Activity context, List<Record> recordList, DatabaseReference databaseRef) {
        super(context, R.layout.sample_record, recordList);
        this.context = context;
        this.recordList = recordList;
        this.databaseRef = databaseRef;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_record, null, true);
        View view1 = layoutInflater.inflate(R.layout.activity_show_records, null, true);
        Record record = recordList.get(position);
        TextView t1 = view.findViewById(R.id.record_date);
        TextView t2 = view.findViewById(R.id.record_time);
        TextView t3 = view.findViewById(R.id.record_heart);
        TextView t4 = view.findViewById(R.id.record_systolic);
        TextView t5 = view.findViewById(R.id.record_dyastolic);
        Button t6 = view.findViewById(R.id.record_update);
        Button t7 = view.findViewById(R.id.record_delete);

        t1.setText("Date:"+record.getDate());
        t2.setText("Time:"+record.getTime());
        t3.setText("Heartrate:"+record.getHeart());



        t4.setText("Systolic Pressure:"+record.getSystolic());
        t5.setText("Dyastolic Pressure:"+record.getDyastolic());


        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItem(position);

            }
        });



        return view;
    }


    public void deleteItem(int position) {
        Record data = recordList.get(position);

        String childKey = data.getChildKey();

        DatabaseReference nodeRef = databaseRef.child(childKey);
        nodeRef.removeValue();
        return;
    }
}
