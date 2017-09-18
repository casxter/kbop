package com.kbop.util;

import java.util.UUID;

/**
 * @author WallaceTang
 */
public class UUIDUtil {
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
