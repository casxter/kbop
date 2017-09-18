package com.kbop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by WallaceTang on 2017/5/19.
 */
public class Log4jTest extends BaseTest {
    @Test
    public void name() throws Exception {
        Logger log = LogManager.getLogger();
        log.info("log test");
    }
}
