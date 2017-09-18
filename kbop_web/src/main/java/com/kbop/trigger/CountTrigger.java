package com.kbop.trigger;

import com.kbop.mapper.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component()
@Lazy
public class CountTrigger {
    @Autowired
    StatisticsMapper statisticsMapper;

    //每天 0:0 运行
//    @Scheduled(cron = "0 0 0 * * ?")
    public void count() {
        System.out.println("Scheduled method");
    }
}
