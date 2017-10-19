package com.kbop.service;

import com.kbop.bean.vo.BookListVo;

/**
 * @author WallaceTang
 */
public interface BookService {
    BookListVo queryAll(int pageNum, int pageSize);

    long totalBookCount();
}
