package com.kbop.bean.vo;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component
public class EmailJson {

    @NotNull
    @Min(value = 1L)
    Long bookId;
    @Email
    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
