package com.kbop.util;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author WallaceTang
 */
public class PropertiesUtilTest {
    @Test
    public void name() throws Exception {
        String str = PropertiesUtil.readProperties("sysconfig.properties", "BOOK_DIR_PATH");
        Assert.notNull(str,"BOOK_DIR_PATH null");
        System.out.println(str);
    }
}