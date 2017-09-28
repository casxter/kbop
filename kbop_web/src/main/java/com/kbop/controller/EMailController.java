package com.kbop.controller;

import com.kbop.bean.JsonMsg;
import com.kbop.bean.po.Book;
import com.kbop.bean.vo.EmailJson;
import com.kbop.common.JsonMsgCode;
import com.kbop.common.KBOPConsts;
import com.kbop.mapper.BookMapper;
import com.kbop.service.EMailService;
import com.kbop.util.JsonMsgFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@RestController
public class EMailController {
    private static final Logger logger = LogManager.getLogger(EMailController.class);
    @Autowired
    BookMapper bookMapper;
    @Autowired
    private EMailService eMailService;

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public JsonMsg email(@RequestBody EmailJson emailJson) {
        String email = emailJson.getEmail();
        String bookID = emailJson.getBookId();

        JsonMsg respjson = JsonMsgFactory.defJsonMsg();
        respjson.setCode(JsonMsgCode.ERROR);

        if (email != null && email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
            if (StringUtils.isNumeric(bookID)) {

                int id = Integer.parseInt(bookID);

                Book book = bookMapper.selectByPrimaryKey(id);

                if (book != null) {

                    logger.info("email book id " + id);

                    String extname = "." + book.getExt();
                    String fileName = book.getUrl() + extname;
                    String filePathName = KBOPConsts.BOOK_DIR_PATH + fileName;
                    File file = new File(filePathName);

                    if (file.exists()) {

                        //发邮件书籍
                        if (eMailService.sendMailWithFile(email, "com/kbop", fileName, filePathName)) {
                            respjson.setCode(JsonMsgCode.OK);
                        }
                    }
                }
            }

        return respjson;
    }
}
