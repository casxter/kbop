package com.kbop.mapper;

import com.kbop.bean.po.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookMapper {
    /**
     * @param id
     * @return deleteByID
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return save
     */
    int insert(Book record);

    int insertSelective(Book record);

    /**
     * @param id
     * @return findByID
     */
    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    /**
     * @param record
     * @return update
     */
    int updateByPrimaryKey(Book record);

    List<Book> findByBookName(@Param("bookName") String bookName);


    List<Book> queryAll();
}