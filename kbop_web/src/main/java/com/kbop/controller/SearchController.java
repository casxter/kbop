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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@RestController
@CrossOrigin
public class SearchController {
    private static final Logger logger = LogManager.getLogger(SearchController.class);

    @Autowired
    BookMapper bookMapper;

    @RequestMapping("/search")
    public JsonMsg<BookListVo> search(
            @RequestParam(value = "q", defaultValue = "") String qstr,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "15") int pageSize,
            Model model) {

        logger.info("search q: " + qstr);

        Page<Book> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> bookMapper.findByBookName(qstr));

        BookListVo booklistvo = new BookListVo(pageNum, pageSize, (int) page.getTotal(), page.getResult());

        return JsonMsgFactory.defJsonMsg(booklistvo);
    }
}
