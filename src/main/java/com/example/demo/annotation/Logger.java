package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger 
{
   private static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
   @Around("execution(* *(..)) && @annotation(com.example.demo.annotation.MethodStats)")
    public Object log(ProceedingJoinPoint point) throws Throwable
   {
      long start = System.currentTimeMillis();
       Object result = point.proceed();
       logger.info("className={}, methodName={}, timeMs={},threadId={}",new Object[]{
            MethodSignature.class.cast(point.getSignature()).getDeclaringTypeName(),
            MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
            System.currentTimeMillis() - start,
            Thread.currentThread().getId()}
          );
       return result;
   }
}