package com.example.kiran.myapplication;

/**
 * Created by Kiran on 10-02-2018.
 */

public class List_items_placement {

    private String head;
    private String body;
    private String id;
    private String filename;
    private String originalfilename;

    public List_items_placement(String head, String body,String id,String filename,String originalfilename) {
        this.head = head;
        this.body = body;
        this.id = id;
        this.filename = filename;
        this.originalfilename = originalfilename;
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getOriginalfilename() {
        return originalfilename;
    }
}
