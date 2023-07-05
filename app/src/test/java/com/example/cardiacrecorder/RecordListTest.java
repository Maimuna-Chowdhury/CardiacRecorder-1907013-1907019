package com.example.cardiacrecorder;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordListTest {

    @Test
    public void testAdd()
    {
        RecordList recordList=new RecordList();
        Record record1=new Record("07/07/2023","120","60","85","9:40","xyz","Good");
        Record record2=new Record("09/07/2023","115","65","95","10:45","abc","Fit");
        recordList.add(record1);
        recordList.add(record2);
        assertEquals(2, recordList.getRecords().size());
        assertTrue(recordList.getRecords().contains(record1));
        assertTrue(recordList.getRecords().contains(record2));

    }

    @Test
    public void testAddException()
    {
        RecordList recordList=new RecordList();
        Record record1=new Record("07/07/2023","120","60","85","9:40","xyz","Fit");
        recordList.add(record1);
        assertThrows(IllegalArgumentException.class,()->{
            recordList.add(record1);
        });

    }


    @Test
    public void testDelete()
    {
        RecordList recordList=new RecordList();
        Record record1=new Record("07/07/2023","120","60","85","9:40","xyz","Fit");
        Record record2=new Record("09/07/2023","115","65","95","10:45","abc","Fit");
        recordList.add(record1);
        recordList.add(record2);
        recordList.delete(record1);
        assertFalse(recordList.getRecords().contains(record1));

    }

    @Test
    public void testDeleteException() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("07/07/2023", "120", "60", "85", "9:59", "abc","Good");
        Record record2 = new Record("09/07/2023", "115", "65", "95", "10:45", "abc","Fit");
        recordList.add(record1);
        recordList.add(record2);
        recordList.delete(record1);
        assertThrows(IllegalArgumentException.class, () -> {
            recordList.delete(record1);
        });
    }

    @Test
    public void testCount()
    {
        RecordList recordList = new RecordList();
        Record record1 = new Record("07/07/2023", "120", "60", "85", "9:59", "abc","Fit");
        Record record2 = new Record("09/07/2023", "115", "65", "95", "10:45", "abc","Good");
        recordList.add(record1);
        recordList.add(record2);
        assertEquals(2,recordList.count());
        recordList.delete(record2);
        assertEquals(1,recordList.count());

    }

    @Test
    public void testUpdate()
    {
        RecordList recordList = new RecordList();
        Record record1 = new Record("07/07/2023", "120", "60", "85", "9:59", "abc","Fit");
        recordList.add(record1);
        assertTrue(recordList.getRecords().contains(record1));

        Record record2 = new Record("09/07/2023", "115", "65", "95", "10:45", "abc","Good");
        recordList.update(0,record2);
        assertFalse(recordList.getRecords().contains(record1));
        assertTrue(recordList.getRecords().contains(record2));

    }



}