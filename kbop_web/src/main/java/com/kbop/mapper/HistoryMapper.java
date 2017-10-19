package com.kbop.mapper;

import com.kbop.bean.po.History;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);
}