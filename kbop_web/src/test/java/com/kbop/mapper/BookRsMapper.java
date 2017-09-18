package com.kbop.mapper;

import com.kbop.bean.po.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WallaceTang on 2017/5/17.
 */
public class BookRsMapper implements RowMapper<Book> {

    @Override
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
