package com.controller;
/**
 * ClassName:    HelloWorldController
 * Package:    com.controller
 * Description:
 * Datetime:    2021/1/20   9:51 下午
 * Author:   tanglintao
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: tanglintao
 *
 * @ClassName: HelloWorldController
 *
 * @Date: 2021/01/20 21:51
 *
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value="/hello")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";
    }
}
