package com.kbop.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesUtil {
    /**
     * 从流中读取properties
     *
     * @param stream 文件输入流
     * @param name
     * @return
     */
    public static String readProperties(InputStream stream, String name) {
        Properties prop = new Properties();
        try {
            prop.load(new InputStreamReader(stream, StandardCharsets.UTF_8.name()));
            return prop.getProperty(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String readProperties(String path, String name) {
        return readProperties(PropertiesUtil.class.getClassLoader().getResourceAsStream(path), name);
    }
}
