package com.kbop.bean.po;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookCount {
    private Long id;

    private Integer dcount;

    private Integer ecount;

    private Date time;

    private Long bookid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDcount() {
        return dcount;
    }

    public void setDcount(Integer dcount) {
        this.dcount = dcount;
    }

    public Integer getEcount() {
        return ecount;
    }

    public void setEcount(Integer ecount) {
        this.ecount = ecount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }
}