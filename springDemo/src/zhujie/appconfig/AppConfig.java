package zhujie.appconfig;

import org.springframework.context.annotation.Bean;
import zhujie.bean.Person;

public class AppConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
