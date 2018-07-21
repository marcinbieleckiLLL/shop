package com.simplycoolest.utils.annotations.logging;

import com.simplycoolest.filter.MainFilter;
import com.simplycoolest.utils.annotations.ProceedingJoinPointUtil;
import com.simplycoolest.utils.annotations.saveCurrentInfo.SaveCurrentUri;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Marcin on 04.05.2018.
 */
@Aspect
@Component
public class LogMethodNameAspect extends ProceedingJoinPointUtil{

    private static final String TAG = "Current method name is -> ";
    private static Logger logger;

    @Around("@annotation(LogMethodName)")
    public Object logMethodName(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = getMethod(joinPoint);
        logger = LoggerFactory.getLogger(method.getAnnotation(LogMethodName.class).value());
        logger.info(TAG + method.getName());
        return joinPoint.proceed();
    }
}
