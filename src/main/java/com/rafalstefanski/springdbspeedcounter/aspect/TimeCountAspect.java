package com.rafalstefanski.springdbspeedcounter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeCountAspect {

    private final Logger logger = LoggerFactory.getLogger(TimeCountAspect.class);

    public TimeCountAspect() {
    }

    @Around("@annotation(TimeCountAnnotation)")
    private void aroundTimeCount(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("   Time counter: Start");
        double start = System.currentTimeMillis();
        joinPoint.proceed();
        double stop = System.currentTimeMillis();
        logger.info("   Time counter: Stop -> Time measured = " + (stop - start) + " nanoseconds\n");
    }
}
