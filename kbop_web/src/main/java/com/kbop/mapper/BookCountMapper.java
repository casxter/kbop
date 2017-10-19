package com.kbop.mapper;

import com.kbop.bean.po.BookCount;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookCountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BookCount record);

    int insertSelective(BookCount record);

    BookCount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookCount record);

    int updateByPrimaryKeyWithBLOBs(BookCount record);

    int updateByPrimaryKey(BookCount record);

}