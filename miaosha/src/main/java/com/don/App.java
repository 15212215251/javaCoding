package com.don;

import com.don.controller.UserController;
import com.don.dao.UserDOMapper;
import com.don.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 项目启动入口
 *
 * @author don
 */
@SpringBootApplication(scanBasePackages = {"com.don"})
@RestController
@MapperScan("com.don.dao")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
