package com.kbop.controller;

import com.kbop.bean.JsonMsg;
import com.kbop.bean.vo.BookListVo;
import com.kbop.mapper.BookMapper;
import com.kbop.service.BookService;
import com.kbop.util.JsonMsgFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WallaceTang on 2017/5/17.
 */
@RestController
@CrossOrigin
public class BookController {
    private static final Logger logger = LogManager.getLogger(BookController.class);

    @Autowired
    BookMapper bookMapper;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public JsonMsg<BookListVo> booklist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {

        BookListVo booklistvo = bookService.queryAll(pageNum, pageSize);

        return JsonMsgFactory.defJsonMsg(booklistvo);
    }

    @RequestMapping(value = "/bookcount", method = RequestMethod.GET)
    public JsonMsg<Map<String, Integer>> bookCount() {

        long count = bookService.totalBookCount();
        Map<String, Long> map = new HashMap<>();
        map.put("totalBookCount", count);
        return JsonMsgFactory.defJsonMsg(map);
    }
}
