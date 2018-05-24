package com.imi.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by mi on 2018/5/24.
 */
@Aspect
@Component
public class DataSourceAspect {

    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.imi.service.primary.*.*(..))")
    public void primaryDeclareJointPointExpression() {
    }

    @Before("primaryDeclareJointPointExpression()")
    public void setPrimaryDataSourceKey(JoinPoint point){
        //根据连接点所属的类实例，动态切换数据源
        DatabaseContextHolder.setDatabaseType(DatabaseType.primary);
    }

    @Pointcut("execution(* com.imi.service.secondary.*.*(..))")
    public void secondaryDeclareJointPointExpression() {
    }

    @Before("secondaryDeclareJointPointExpression()")
    public void setSecondaryDataSourceKey(JoinPoint point){
        //根据连接点所属的类实例，动态切换数据源
        DatabaseContextHolder.setDatabaseType(DatabaseType.secondary);
    }
}
