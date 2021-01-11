package zhujie.bean;


//基于java注解注入bean
public class Person {

    public String name;

    public String sex;

    public Phone phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Person() {
    }

    public Person(String name, String sex, Phone phone) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
//                ", phone=" + phone +
//                '}';
//    }
}
