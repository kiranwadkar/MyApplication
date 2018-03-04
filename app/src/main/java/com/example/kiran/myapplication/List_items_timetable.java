package com.example.kiran.myapplication;

/**
 * Created by Kiran on 02-03-2018.
 */

public class List_items_timetable {
    private String subject;
    private String teacher;
    private String start_time;
    private String end_time;
    private String block;

    public List_items_timetable(String subject, String teacher, String start_time, String end_time, String block) {
        this.subject = subject;
        this.teacher = teacher;
        this.start_time = start_time;
        this.end_time = end_time;
        this.block = block;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getBlock() {
        return block;
    }
}
