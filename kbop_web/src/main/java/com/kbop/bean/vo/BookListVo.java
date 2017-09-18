package com.kbop.bean.vo;

import com.kbop.bean.po.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component
public class BookListVo {
    int start;
    int perPageCount;
    int totalBookCount;
    List<Book> list;

    public BookListVo() {
    }

    public BookListVo(int start, int perPageCount, int totalBookCount, List<Book> list) {
        this.start = start;
        this.perPageCount = perPageCount;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPerPageCount() {
        return perPageCount;
    }

    public void setPerPageCount(int perPageCount) {
        this.perPageCount = perPageCount;
    }
}
