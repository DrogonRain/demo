package cn.zhangbin.selfstudy.day03;

import java.util.Arrays;
import java.util.Comparator;

public class Demo2 {
    public static void main(String[] args) {
        Person2[] per = new Person2[] {
                new Person2("张三",30),
                new Person2("李四",40),
                new Person2("王五",10)
        };
        Arrays.sort(per,new PersonComparator());
        System.out.println(Arrays.toString(per));
    }
}
class PersonComparator implements Comparator<Person2>{ // 创建类实现Comparator接口进行比较

    @Override
    public int compare(Person2 o1, Person2 o2) {// 创建比较方法
        return o1.getAge() - o2.getAge(); //实现升序
    }
}
class Person2{
    private String name;
    private int age;

    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
