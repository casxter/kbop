package com.kbop.util;

import org.junit.Test;

/**
 * @author WallaceTang
 */
public class PropertiesUtilTest {
    @Test
    public void name() throws Exception {
        String str = PropertiesUtil.readProperties("sysconfig.properties", "BOOK_DIR_PATH");
        System.out.println(str);
    }
}