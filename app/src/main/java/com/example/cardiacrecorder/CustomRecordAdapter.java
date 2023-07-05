package com.example.cardiacrecorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

       // Button t6 = view.findViewById(R.id.record_update);
        Button t7 = view.findViewById(R.id.record_delete);
        TextView t8=view.findViewById(R.id.record_comment);
        TextView t5 = view.findViewById(R.id.record_dyastolic);
        t1.setText("Date:"+record.getDate());
        t2.setText("Time:"+record.getTime());
        t3.setText("Heartrate:"+record.getHeart());







        if(Integer.parseInt(record.getSystolic())>=90&&Integer.parseInt(record.getSystolic())<=140) {
            if (Integer.parseInt(record.getDyastolic()) <= 60 && Integer.parseInt(record.getDyastolic()) >= 90)
            {
                t8.setText("Fit");
            t4.setText("Systolic Pressure:" + record.getSystolic());
            t5.setText("Dyastolic Pressure:" + record.getDyastolic());
        }
            else
            {
                t8.setText("Pressure Not Normal");
                t4.setTextColor(Color.RED);
                t5.setTextColor(Color.RED);
                t4.setText("Systolic Pressure:" + record.getSystolic());
                t5.setText("Dyastolic Pressure:" + record.getDyastolic());
            }



        }
        else if(Integer.parseInt(record.getDyastolic()) <= 60 && Integer.parseInt(record.getDyastolic()) >= 90)
        {
            if(Integer.parseInt(record.getSystolic())>=90&&Integer.parseInt(record.getSystolic())<=140)
            {
                t8.setText("Fit");
                t4.setText("Systolic Pressure:" + record.getSystolic());
                t5.setText("Dyastolic Pressure:" + record.getDyastolic());
            }
            else
            {
                t8.setText("Pressure Not Normal");
                t4.setTextColor(Color.RED);
                t5.setTextColor(Color.RED);
                t4.setText("Systolic Pressure:" + record.getSystolic());
                t5.setText("Dyastolic Pressure:" + record.getDyastolic());
            }
        }
        else
        {
            t8.setText("Pressure Not Normal");
            t4.setTextColor(Color.RED);
            t5.setTextColor(Color.RED);
            t4.setText("Systolic Pressure:" + record.getSystolic());
            t5.setText("Dyastolic Pressure:" + record.getDyastolic());
        }



        /*t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record data = recordList.get(position);
                String childKey = data.getChildKey();
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("childKey", childKey);
                context.startActivity(intent);
            }
        });*/

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItem(position);

            }
        });


    view.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Record data = recordList.get(position);
            String childKey = data.getChildKey();
            Intent intent=new Intent(context,UpdateActivity.class);
            intent.putExtra("childKey", childKey);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
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
