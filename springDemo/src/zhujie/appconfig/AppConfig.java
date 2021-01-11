package zhujie.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zhujie.bean.Person;
//@Configuration
public class AppConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
