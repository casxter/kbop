package com.kbop.config;

import com.kbop.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by WallaceTang on 2017/5/17.
 */
public class DataConfigTest extends BaseTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void dataSource() throws Exception {

    }

    @Test
    public void sqlSessionFactory() throws Exception {

    }

    @Test
    public void jdbcTemplate() throws Exception {
        Assert.assertNotNull(jdbcTemplate);
    }

}