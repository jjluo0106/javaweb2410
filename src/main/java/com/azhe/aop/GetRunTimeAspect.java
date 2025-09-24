package com.azhe.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GetRunTimeAspect {



    @Around("@annotation(com.azhe.anno.GetRunTime)")
    public Object printRunTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //獲取該方法名稱
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "被調用了...");
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(methodName + "  方法執行時間 ：" + (end - start) + "ms");
        return result;
    }
}
