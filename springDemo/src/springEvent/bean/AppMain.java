package springEvent.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext.start();
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloworld");
        helloWorld.getMessage();
        applicationContext.stop();

    }
}
