package com.kbop.mapper;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kbop.bean.po.Book;
import com.kbop.config.DataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;


/**
 * Created by WallaceTang on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DataConfig.class)
//@ActiveProfiles(profiles = "dev")
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Book book = bookMapper.selectByPrimaryKey(50);
        System.out.println(book);
    }

    @Test
    public void findByBookName() {
        List<Book> list = bookMapper.findByBookName("战争");
        System.out.println(list);
    }

    @Test
    public void queryAll() throws Exception {
        Page<Book> page = PageHelper.startPage(1, 15).doSelectPage(() -> bookMapper.queryAll());

        System.out.printf("");
    }
}