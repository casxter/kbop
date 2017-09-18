package com.kbop.common;

import com.kbop.util.PropertiesUtil;
import org.springframework.stereotype.Component;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Component
public class KBOPConsts {
    /**
     * 书储存目录
     */
    public static final String BOOK_DIR_PATH = PropertiesUtil.readProperties("sysconfig.properties", "BOOK_DIR_PATH");

}
