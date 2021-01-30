package bean;/**
 * ClassName:    HelloController
 * Package:    bean
 * Description:
 * Datetime:    2021/1/18   10:13 下午
 * Author:   tanglintao
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: tanglintaoø
 * @ClassName: HelloController
 * @Date: 2021/01/18 22:13
 */

@Controller
@RequestMapping("/hello")
public class HelloController{
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "/WEB-INF/hello.jsp";
    }
}
