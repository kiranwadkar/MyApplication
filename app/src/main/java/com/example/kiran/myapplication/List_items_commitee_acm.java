package com.example.kiran.myapplication;

/**
 * Created by Kiran on 11-02-2018.
 */

public class List_items_commitee_acm {
    private String head;
    private String body;
    private String price;
    private String contact;
    private String id;
    private String filename;
    private String origfilename;

    public List_items_commitee_acm(String head,String body,String price,String contact,String id,String filename,String origfilenm) {
        this.head = head;
        this.body = body;
        this.price = price;
        this.contact = contact;
        this.id = id;
        this.filename =filename;
        this.origfilename = origfilenm;
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    public String getPrice() {
        return price;
    }

    public String getContact() {
        return contact;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getOrigfilename() {
        return origfilename;
    }
}
