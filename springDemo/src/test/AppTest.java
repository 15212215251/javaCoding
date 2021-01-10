package test;

import bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//spring demo 的测试类
public class AppTest {

    public static void main(String[] args) {
//        初始化一个spring容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.toString());
    }

}
