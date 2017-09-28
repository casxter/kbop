package com.kbop.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kbop.bean.JsonMsg;
import com.kbop.bean.po.Book;
import com.kbop.bean.vo.BookListVo;
import com.kbop.mapper.BookMapper;
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

    @RequestMapping(value = "/booklist", method = RequestMethod.POST)
    public JsonMsg<BookListVo> booklist(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {

        Page<Book> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> bookMapper.queryAll());

        BookListVo booklistvo = new BookListVo(pageNum, pageSize, (int) page.getTotal(), page.getResult());

        return JsonMsgFactory.defJsonMsg(booklistvo);
    }

    @RequestMapping(value = "/bookcount", method = RequestMethod.GET)
    public JsonMsg<Map<String, Integer>> bookCount() {
        long count = PageHelper.count(() -> bookMapper.queryAll());
        Map<String, Integer> map = new HashMap<>();
        map.put("totalBookCount", (int) count);
        return JsonMsgFactory.defJsonMsg(map);
    }
}
