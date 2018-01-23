package lolipop.core.aspect;


import lolipop.common.constant.DataSourceName;
import lolipop.core.DataSourceContextHolder;
import lolipop.core.annotation.DynamicDataSource;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 名称：DataSourceAspect<br>
 * <p>
 * 描述：切换数据源 aop 切面（order=1 优先级最高）<br>
 */
public class DataSourceAspect implements MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * 前置通知（用于在事物开启之前切换数据源）<br>
     *
     * @see MethodBeforeAdvice#before(Method, Object[], Object)
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (method.isAnnotationPresent(DynamicDataSource.class)) {
            DynamicDataSource dataSource = method.getAnnotation(DynamicDataSource.class);
            if (dataSource.value() != DataSourceName.DEFAULT) {
                DataSourceContextHolder.setDataSource(dataSource.value().getName());
            }
        }
    }

    /**
     * 后置通知（用于清理切换过的数据源，还原默认数据源）<br>
     *
     * @see AfterReturningAdvice#afterReturning(Object, Method, Object[], Object)
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if (method.isAnnotationPresent(DynamicDataSource.class)) {
            DynamicDataSource dataSource = method.getAnnotation(DynamicDataSource.class);
            if (dataSource.value() != DataSourceName.DEFAULT) {
                DataSourceContextHolder.clearDataSource();
            }
        }
    }

}
