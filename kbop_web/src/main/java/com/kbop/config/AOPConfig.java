package com.kbop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by WallaceTang on 2017/5/19.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig {
}
