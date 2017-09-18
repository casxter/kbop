package com.kbop.jdbc;

import com.kbop.BaseTest;
import com.kbop.bean.po.Book;
import com.kbop.mapper.BookRsMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WallaceTang on 2017/5/17.
 */
public class JdbcRepository extends BaseTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        Book book = jdbcTemplate.queryForObject("select * from book where id = 7", new BookRsMapper());
        System.out.println(book);
    }

    @Test
    public void test1() {
        //lambda
        Book book = jdbcTemplate.queryForObject("select * from book where id = 7", ((rs, rowNum) -> {
            Book entry = new Book();
            entry.setId(rs.getInt("ID"));
            entry.setBookName(rs.getString("BookName"));
            entry.setExt(rs.getString("Ext"));
            entry.setUrl(rs.getString("URL"));
            entry.setSize(rs.getString("Size"));
            entry.setAuthor(rs.getString("Author"));
            entry.setTime(rs.getDate("Time"));

            return entry;
        }));
        System.out.println(book);
    }

    @Test
    public void test2() {
        //方法引用
        Book book = jdbcTemplate.queryForObject("select * from book where id = 7", this::mapRow);
        System.out.println(book);
    }

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("ID"));
        book.setBookName(rs.getString("BookName"));
        book.setExt(rs.getString("Ext"));
        book.setUrl(rs.getString("URL"));
        book.setSize(rs.getString("Size"));
        book.setAuthor(rs.getString("Author"));
        book.setTime(rs.getDate("Time"));

        return book;
    }
}
