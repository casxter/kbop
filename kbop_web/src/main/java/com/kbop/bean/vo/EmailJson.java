package com.kbop.bean.vo;

import org.springframework.stereotype.Component;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component
public class EmailJson {

    String email;
    String bookId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
