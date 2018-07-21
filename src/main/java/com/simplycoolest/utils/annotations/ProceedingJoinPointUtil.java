package com.simplycoolest.utils.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by Marcin on 04.05.2018.
 */
public class ProceedingJoinPointUtil {
    protected Method getMethod(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }
}
