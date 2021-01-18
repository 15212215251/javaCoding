package aop_xml_demo2.bean;/**
 * ClassName:    Logging
 * Package:    aop_xml_demo2.bean
 * Description:
 * Datetime:    2021/1/17   9:13 上午
 * Author:   tanglintao
 */

/**
 * @author: tanglintao
 * @ClassName: Logging
 * @Date: 2021/01/17 09:13
 */
public class Logging {

    /**
    * @Description
    * aop before method ...
    * * @return void 
    * @author  don
    * @Datetime  2021/1/17 9:13 上午
    */
    public void before() {
        System.out.println("this is before method ...");
    }

    public void afteReturn() {
        System.out.println("this is after return method ....");
    }

    public void after() {
        System.out.println("this is after method ...");
    }
}
