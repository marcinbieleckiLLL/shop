package com.simplycoolest.utils.annotations.saveCurrentInfo;

import com.simplycoolest.dto.CurrentInfo;
import com.simplycoolest.utils.annotations.ProceedingJoinPointUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by Marcin on 04.05.2018.
 */
@Aspect
@Component
public class SaveCurrentInfoAspect extends ProceedingJoinPointUtil{

    @Resource(name = "currentInfo")
    CurrentInfo currentInfo;

    @Around("@annotation(SaveCurrentUri)")
    public Object saveCurrentUri(ProceedingJoinPoint joinPoint) throws Throwable {
        SaveCurrentUri saveCurrentUri = getMethod(joinPoint).getAnnotation(SaveCurrentUri.class);
        currentInfo.setRedirectUri(saveCurrentUri.value());
        return joinPoint.proceed();
    }
}
