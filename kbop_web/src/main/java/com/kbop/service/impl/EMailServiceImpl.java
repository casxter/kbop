package com.kbop.service.impl;

import com.kbop.service.EMailService;
import com.kbop.util.EMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WallaceTang on 2017/6/15.
 */
@Service
public class EMailServiceImpl implements EMailService {

    @Autowired
    EMail eMail;

    @Override
    public boolean sendMail(String recver, String subject, String text) {
        return eMail.sendMail(recver, subject, text);
    }

    @Override
    public boolean sendMailWithFile(String recver, String subject, String text, String uri) {
        return eMail.sendMailWithFile(recver, subject, text, uri);
    }
}
