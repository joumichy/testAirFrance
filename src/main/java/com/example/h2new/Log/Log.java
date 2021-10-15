package com.example.h2new.Log;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

@Aspect
@Component
public class Log {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(Log.class));
    private int order;


    @Around("userPointCut()")
    public Object executer(final ProceedingJoinPoint joinPoint) throws Throwable{

        Object returnvalue;
        StopWatch clock = new StopWatch(getClass().getName());
        try{
            clock.start(joinPoint.toString());
            returnvalue = joinPoint.proceed();

        }finally {
            clock.stop();
            LOGGER.info("Temps d'execution : "+ clock.prettyPrint());
        }
        return returnvalue;
    }

    @Pointcut("execution(* com.example.h2new.service.*UserService.*(..))")
    public void userPointCut(){

    }

}
