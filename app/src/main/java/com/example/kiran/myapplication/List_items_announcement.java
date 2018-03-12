package com.example.kiran.myapplication;

/**
 * Created by Kiran on 10-02-2018.
 */

public class List_items_announcement {

   // private static String head1;
    private  String head;
    private  String body;
    private String id;

    public List_items_announcement(String head, String body,String id) {
        this.head = head;
        this.body = body;
        this.id = id;
    }

    public  String getHead() {
        return head;
    }

    public  String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }
}
