package com.kbop.mapper;

import com.kbop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by WallaceTang on 2017/5/19.
 */
public class StatisticsMapperTest extends BaseTest {
    @Autowired
    StatisticsMapper statisticsMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(statisticsMapper.selectByPrimaryKey(1479));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}