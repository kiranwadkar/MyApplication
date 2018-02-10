package com.example.kiran.myapplication;

/**
 * Created by Kiran on 10-02-2018.
 */

public class List_items_announcement {

   // private static String head1;
    private static String head;
    private static String body;

    public List_items_announcement(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public static String getHead() {
        return head;
    }

    public static String getBody() {
        return body;
    }
}
