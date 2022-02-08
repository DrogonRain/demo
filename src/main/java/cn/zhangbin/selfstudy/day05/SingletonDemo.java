package cn.zhangbin.selfstudy.day05;

public class SingletonDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                Singleton.getInstance().print();
            },"单例消费端-"+i).start();
        }
    }
}
class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){
        System.out.println("["+Thread.currentThread().getName()+"]***** 实例化Singleton类对象 *****");
    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println("www.baidu.com");
    }
}
