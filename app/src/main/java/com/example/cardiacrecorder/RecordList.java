package com.example.cardiacrecorder;

import java.util.ArrayList;
import java.util.List;

public class RecordList {
    private List<Record> records=new ArrayList<>();

    /**
     *
     * @param record adds new record
     */
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

    /**
     *
     * @param record deletes a record
     */
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

    /**
     * returns total count
     * @return
     */

    public int count()
    {
        return records.size();
    }

    /**
     * updates a record
     * @param pos
     * @param record
     */

    public void update(int pos, Record record)
    {
        records.set(pos,record);
    }

}
