package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class Demo10 {
    private static final File SAVE_FILE = new File(File.separator+"Users"+File.separator+"zhangbin"+File.separator+"Desktop"+File.separator+"Study"+File.separator+"StudyTest"+File.separator+"test2.person");
    public static void main(String[] args) throws Exception{
//        saveObject(new Person("张三",21));
        System.out.println(loadObject());
    }
    public static void saveObject(Object obj) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();
    }
    public static Object loadObject() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object o = ois.readObject(); // 反序列化
        ois.close();
        return o;
    }
}
class Person implements Serializable{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
