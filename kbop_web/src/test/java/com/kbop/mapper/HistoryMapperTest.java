package com.kbop.mapper;

import com.kbop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by WallaceTang on 2017/5/19.
 */
public class HistoryMapperTest extends BaseTest {
    @Autowired
    HistoryMapper historyMapper;

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
        historyMapper.selectByPrimaryKey(27L);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}