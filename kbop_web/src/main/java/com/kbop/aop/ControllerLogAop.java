package com.kbop.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author WallaceTang
 */
@Aspect
@Component
public class ControllerLogAop {
    private static final Logger logger = LogManager.getLogger(ControllerLogAop.class);

    //com.kbop.service.impl 包下的所有类 所有方法
    @Pointcut(value = "execution(* com.kbop.controller.*.*(..))")
    public void controllerInvokeStatistics() {
    }


    @Before(value = "controllerInvokeStatistics()")
    public void controllerInvokeStatisticsBefore(JoinPoint joinPoint) {

        logger.info("controllerInvokeStatisticsBefore");
    }
}
