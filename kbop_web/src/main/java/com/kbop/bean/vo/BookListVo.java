package com.kbop.bean.vo;

import com.kbop.bean.po.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component
public class BookListVo {
    int pageNum;
    int pageSize;
    int totalBookCount;
    List<Book> list;

    public BookListVo() {
    }

    public BookListVo(int pageNum, int pageSize, int totalBookCount, List<Book> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalBookCount = totalBookCount;
        this.list = list;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(int totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
