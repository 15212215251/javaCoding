package com.don.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
}
