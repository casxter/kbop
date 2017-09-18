package com.kbop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 统计 aop
 *
 * @author WallaceTang
 */
@Aspect
@Component
public class StatisticsAOP {
    public static final String EVENT_DOWNLOAD = "download";
    public static final String EVENT_EMAIL = "email";

//   @AfterReturning(value = "execution(* com.kbop.controller.DownloadController(..))")
//   public void downloadAOP(){
//      System.out.println("after download Book");
//   }
}
