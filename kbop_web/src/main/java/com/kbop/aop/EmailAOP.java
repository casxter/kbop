package com.kbop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Aspect
@Component
public class EmailAOP {

//    //发邮件 aop
//    @Pointcut("execution(** com.kbop.util.Test.test(..))")
//    public void sendEmail() {
//    }
//
//    @AfterReturning(value = "sendEmail()", returning = "responecode")
//    public void aftersendEmail(JoinPoint point, Object responecode) {
//
//        System.out.println("参数：" + Arrays.toString(point.getArgs()));
//        System.out.println("返回值：" + responecode);
//    }
}
