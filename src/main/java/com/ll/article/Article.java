package com.ll.article;

import java.util.Map;

public class Article {
    private int id;
    private String title;
    private String content;
    private int contentType;

    public Article(int id, int contentType, String subject, String content) {
        this.id = id;
        this.contentType = contentType;
        this.title = title;
        this.content = content;
    }

    public Article(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.contentType = (int)row.get("contentType");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
    }

    int getId() {
        return this.id;
    }

    String getSubject() {
        return this.title;
    }
    String getContent() {
        return this.content;
    }
    int getContentType() {
        return this.contentType;
    }

    public void setSubject(String subject) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
}