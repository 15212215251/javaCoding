package aop_xml_demo2.bean;/**
 * ClassName:    MainApp
 * Package:    aop_xml_demo2.bean
 * Description:
 * Datetime:    2021/1/17   9:21 上午
 * Author:   tanglintao
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: tanglintao
 * @ClassName: MainApp
 * @Date: 2021/01/17 09:21
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("aop_demo_xml2.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.myname());
    }
}
