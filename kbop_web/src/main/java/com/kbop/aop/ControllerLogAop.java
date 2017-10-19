package com.kbop.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WallaceTang
 */
@Aspect
@Component
public class ControllerLogAop {
    private static final Logger logger = LogManager.getLogger(ControllerLogAop.class);

    //com.kbop.service.impl 包下的所有类 所有方法
    @Pointcut(value = "execution(* com.kbop.controller.*.*(..)) " +
            "&& @annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "&& @target(org.springframework.web.bind.annotation.RestController)")
    public void controllerInvokeLog() {
    }


    @Before(value = "controllerInvokeLog()")
    public void controllerInvokeLogBefore(JoinPoint joinPoint) {
        //获取url
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String uri = request.getRequestURI();

        logger.info("request url: " + uri);

        Object[] args = joinPoint.getArgs();

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        StringBuilder sb = new StringBuilder(targetName + "." + methodName + " (");

        for (Object arg : args) {
            sb.append(JSONObject.toJSONString(arg) + ',');
        }

        int idx = sb.lastIndexOf(",");
        if (idx != -1)
            sb.deleteCharAt(idx);

        sb.append(")");

        logger.info(sb.toString());
    }
}
