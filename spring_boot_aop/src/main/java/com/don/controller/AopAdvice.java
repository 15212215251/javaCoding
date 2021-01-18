package com.don.controller;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopAdvice {

    @Pointcut("execution(* com.don.controller.*.*(..))")
    public void log() {

    }


    @Before("log()")
    public void before() {
        System.out.println("before method ...");
    }

    @After("log()")
    public void after() {
        System.out.println("this is after metod ...");
    }

    @AfterReturning("log()")
    public void afterReturn() {
        System.out.println("this is after return method ...");
    }
}
