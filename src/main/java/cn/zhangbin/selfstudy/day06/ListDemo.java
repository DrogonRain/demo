package cn.zhangbin.selfstudy.day06;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("张三",22));
        list.add(new Person("李四",24));
        list.add(new Person("李四",24));
        list.add(new Person("王五",21));
//        System.out.println(list.contains(new Person("张三",22)));
//        System.out.println(list.remove(new Person("李四",24)));
        list.forEach(System.out::println);
        System.out.println("----------------------");
        Set<Person> test = new HashSet<Person>();
        test.add(new Person("张三",22));
        test.add(new Person("李四",24));
        test.add(new Person("李四",24));
        test.add(new Person("王五",21));
        test.forEach(System.out::println);
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Person per) {
        if (this.age < per.age){
            return -1;
        }else if (this.age > per.age){
            return 1;
        }else {
            return this.name.compareTo(per.name);
        }
    }
}
