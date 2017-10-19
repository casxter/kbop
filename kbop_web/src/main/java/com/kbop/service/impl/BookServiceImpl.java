package com.kbop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kbop.bean.po.Book;
import com.kbop.bean.vo.BookListVo;
import com.kbop.mapper.BookMapper;
import com.kbop.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WallaceTang
 */
@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Override
    public BookListVo queryAll(int pageNum, int pageSize) {

        Page<Book> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> bookMapper.queryAll());

        BookListVo booklistvo = new BookListVo(pageNum, pageSize, (int) page.getTotal(), page.getResult());

        return booklistvo;
    }

    @Override
    public long totalBookCount() {
        long count = PageHelper.count(() -> bookMapper.queryAll());

        return count;
    }

}
