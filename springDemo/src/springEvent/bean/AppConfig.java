package springEvent.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    public CStartEventHandle cStartEventHandle() {
        return new CStartEventHandle();
    }

    @Bean
    public CStopEventHandle cStopEventHandle() {
        return new CStopEventHandle();
    }

}
