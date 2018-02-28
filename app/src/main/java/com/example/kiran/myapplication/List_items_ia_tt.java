package com.example.kiran.myapplication;

/**
 * Created by Kiran on 27-02-2018.
 */

public class List_items_ia_tt {
    private String subject;
    private  String date;
    private  String start_time;
    private  String end_time;

    public List_items_ia_tt(String subject,String date, String start_time, String end_time) {
        this.subject = subject;
        this.date = date;
        this.start_time = start_time;
        this.end_time= end_time;
    }

    public  String getSubject() {
        return subject;
    }

    public  String getDate() {
        return date;
    }

    public String getStart_time() {
        return start_time;
    }

    public  String getEnd_time() {
        return end_time;
    }
}
