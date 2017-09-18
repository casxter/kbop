package com.kbop.mapper;

import com.kbop.bean.po.History;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}