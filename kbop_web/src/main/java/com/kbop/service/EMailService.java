package com.kbop.service;

/**
 * Created by WallaceTang on 2017/6/15.
 */
public interface EMailService {
    boolean sendMail(String recver, String subject, String text);

    boolean sendBook(String email, Long bookId);
}
