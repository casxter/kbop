package com.kbop.mapper;

import com.kbop.bean.po.Statistics;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKeyWithBLOBs(Statistics record);

    int updateByPrimaryKey(Statistics record);
}