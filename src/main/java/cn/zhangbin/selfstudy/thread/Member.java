package cn.zhangbin.selfstudy.thread;

public class Member {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal("兔子",15);
        Animal animal1 = (Animal) animal.clone();
        System.out.println(animal);
        System.out.println(animal1);
    }
}
class Animal implements Cloneable{
    private String name;
    private int age;
    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "["+super.toString()+"]"+"名称: "+this.name+"年龄: "+this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //调用父类的克隆方法
    }
}
