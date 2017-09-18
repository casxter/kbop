package com.kbop.util;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author WallaceTang
 */
public class IOUtilsTest {
    @Test
    public void name() throws Exception {
        byte[] bytes = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\wallacetang\\tmp\\shadowsocks\\user-rule.txt");
        while (IOUtils.read(fileInputStream, bytes) > 0) {
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }
    }
}
