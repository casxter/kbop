package com.kbop.bean.po;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class History {
    private Long id;

    private String ip;

    private Long bookid;

    private String event;

    private String email;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}