package com.murtll.springdemo.utils;

public class EmailModel {

    private String to;
    private String from;
    private String text;
    private String subject;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "EmailModel{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", text='" + text + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
