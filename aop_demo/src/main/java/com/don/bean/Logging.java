package com.don.bean;

public class Logging {

    public void beforeAdvice() {
        System.out.println("beforeAdvice :Going to setup Student profile ...");
    }

    public void afterAdvice() {
        System.out.println("afterAdvice:  Student profile has been setup ...");
    }

    public void afterReturnAdvice(Object restObj) {
        System.out.println("afterReturnAdvice:  Returning " + restObj.toString());
    }

    public void afterThrowingAdvice(IllegalArgumentException illegalArgumentException) {
        System.out.println("There has been an exception " + illegalArgumentException.toString());
    }
}
