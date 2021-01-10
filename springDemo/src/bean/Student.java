package bean;

import java.util.Arrays;

public class Student {

    public Car car;


    public String name;

    public int age;

    public String city;

    public String[] hobbys;

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public String toString() {
        return "Student{" +
                "car=" + car +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", hobbys=" + Arrays.toString(hobbys) +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student() {
    }

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


}
