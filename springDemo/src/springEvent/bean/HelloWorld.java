package springEvent.bean;

import org.springframework.beans.factory.annotation.Value;

public class HelloWorld {

    @Value("hello world")
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("your message is :" + message);
    }
}
