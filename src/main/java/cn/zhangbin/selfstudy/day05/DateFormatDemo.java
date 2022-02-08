package cn.zhangbin.selfstudy.day05;

import java.util.Date;

class Person{}
public class DateFormatDemo {
    public static void main(String[] args) {
        Date date = new Date(); // 通过类产生实例化对象
        System.out.println(date.getClass()); // 根据实例化对象获取对象所属的属性
        Class<?> personClass = Person.class;
        System.out.println(personClass.getName());
    }
}
