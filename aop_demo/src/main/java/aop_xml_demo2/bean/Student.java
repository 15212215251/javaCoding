package aop_xml_demo2.bean;/**
 * ClassName:    Student
 * Package:    aop_xml_demo2.bean
 * Description:
 * Datetime:    2021/1/17   9:14 上午
 * Author:   tanglintao
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: tanglintao
 * @ClassName: Student
 * @Date: 2021/01/17 09:14
 */
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public Integer age;


    public void sayHi() {
        System.out.println("hello ... I am :" + name + " and I am :" + age + " years old .");
    }


    public String myname() {
        return this.name+"toms ";
    }

//    public Student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Student(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
}
