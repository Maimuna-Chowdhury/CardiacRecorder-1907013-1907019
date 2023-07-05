package com.example.cardiacrecorder;

import java.util.ArrayList;
import java.util.List;

public class RecordList {
    private List<Record> records=new ArrayList<>();

    public void add(Record record)
    {
        if(records.contains(record))
        {
            throw new IllegalArgumentException();
        }
        records.add(record);
    }

    public  List<Record> getRecords()
    {
        List<Record> recordList = records;
        return recordList;
    }

    public void delete(Record record)
    {
        if(!records.contains(record))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            records.remove(record);
        }
    }


    public int count()
    {
        return records.size();
    }

    public void update(int pos, Record record)
    {
        records.set(pos,record);
    }

}
