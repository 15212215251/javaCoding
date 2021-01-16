package com.don.test;

import com.don.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getAge());
//        student.printThrowingException();

    }
}
