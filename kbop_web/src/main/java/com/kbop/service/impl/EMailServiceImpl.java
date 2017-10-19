package com.kbop.service.impl;

import com.kbop.bean.po.Book;
import com.kbop.common.KBOPConsts;
import com.kbop.mapper.BookMapper;
import com.kbop.service.EMailService;
import com.kbop.util.EMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by WallaceTang on 2017/6/15.
 */
@Service
public class EMailServiceImpl implements EMailService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    EMail eMail;
    @Autowired
    BookMapper bookMapper;

    @Override
    public boolean sendMail(String recver, String subject, String text) {
        return eMail.sendMail(recver, subject, text);
    }


    @Override
    public boolean sendBook(String email, Long bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);

        if (book != null) {

            logger.info("email book id " + bookId);

            String extname = "." + book.getExt();
            String fileName = book.getUrl() + extname;
            String filePathName = KBOPConsts.BOOK_DIR_PATH + fileName;
            File file = new File(filePathName);

            if (file.exists()) {
                return eMail.sendMailWithFile(email, "com/kbop", fileName, filePathName);
            }
        }

        return false;
    }

}
