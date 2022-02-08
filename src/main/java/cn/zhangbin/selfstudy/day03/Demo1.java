package cn.zhangbin.selfstudy.day03;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        Person[] per = new Person[] { // 创建数组保存对象
                new Person("张三",30),
                new Person("李四",20),
                new Person("王五",40)
        };
        Arrays.sort(per);// 数组排序
        for (int i = 0; i < per.length; i++) { // 遍历数组
            System.out.println(per[i].toString());
        }
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person per) { // 数组排序方法
        return this.age - per.age; // 升序
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
