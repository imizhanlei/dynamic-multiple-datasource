package com.imi.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * Created by mi on 2018/5/24.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // 切点
    @Pointcut("execution(public * com.imi.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("------------------------------------------------------------------");
        // url
        logger.info("url={}",request.getRequestURL());

        // method
        logger.info("method={}",request.getMethod());

        // ip
        logger.info("ip={}",request.getRemoteAddr());

        // 类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());

        // 参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }


}
