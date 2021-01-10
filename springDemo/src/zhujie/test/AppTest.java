package zhujie.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhujie.appconfig.AppConfig;
import zhujie.bean.Person;
import zhujie.bean.Phone;

public class AppTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        person.setName("don");
        person.setSex("male");
        Phone phone = Phone.IPHONE;

        person.setPhone(phone);
        System.out.println(person.toString());
    }
}
