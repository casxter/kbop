package com.kbop.util;

import com.kbop.mapper.StatisticsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by TWJ on 2016-10-15.
 */

public class Statistics {
    private static final Logger logger = LogManager.getLogger(Statistics.class.getName());
    private static int dCount = 0;
    private static int emailCount = 0;
    @Autowired
    private StatisticsMapper statisticsMapper;


    //同步方法 统计每天下载量
    public synchronized boolean downloadCountCheck() {
        //统计每天下载量
        if (dCount + emailCount < 500) {
            dCount++;
            logger.info("dCount: " + dCount + " emailCOunt： " + emailCount);
            return true;
        } else {
            return false;
        }

    }

    //每天检查 下载量 邮件量
    public synchronized void check() {
        try {
            //TODO statisticsDAO
//            statisticsDAO.save("dcount",dCount + "",new Timestamp(System.currentTimeMillis()));
//            statisticsDAO.save("emailcount",emailCount + "",new Timestamp(System.currentTimeMillis()));
            logger.info("DAILY dCount: " + dCount + " emailCOunt： " + emailCount);
            dCount = 0;
            emailCount = 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }    //同步方法 统计每天邮件量

    public synchronized boolean emailCountCheck() {
        //统计每天邮件量
        if (dCount + emailCount < 500) {
            emailCount++;
            logger.info("dCount: " + dCount + " emailCOunt： " + emailCount);
            return true;
        } else {
            return false;
        }

    }

}
