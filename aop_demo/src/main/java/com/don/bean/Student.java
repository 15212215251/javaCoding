package com.don.bean;

public class Student {

    public String name;

    public Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void printThrowingException() {
        System.out.println("Exception Raised ...");
        throw new IllegalArgumentException();
    }
}
