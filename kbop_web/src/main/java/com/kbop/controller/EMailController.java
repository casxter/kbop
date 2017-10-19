package com.kbop.controller;

import com.kbop.bean.JsonMsg;
import com.kbop.bean.vo.EmailJson;
import com.kbop.common.JsonMsgCode;
import com.kbop.mapper.BookMapper;
import com.kbop.service.EMailService;
import com.kbop.util.JsonMsgFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        Long bookID = emailJson.getBookId();

        JsonMsg respjson = JsonMsgFactory.defJsonMsg();
        respjson.setCode(JsonMsgCode.ERROR);

        if (eMailService.sendBook(email, bookID)) {
            respjson.setCode(JsonMsgCode.OK);
            }

        return respjson;
    }
}
