package cn.zhangbin.selfstudy.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Resource resource = new Resource(); // 初始化resource
        new Thread(new MakeThread(resource),"张三").start(); //启动创建线程
        new Thread(new GetThread(resource),"李四").start(); //启动取走线程
    }
}
class MakeThread implements Runnable{ // 调用线程,创建计算机
    private Resource resource;
    public MakeThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.make();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class GetThread implements Runnable{ // 调用线程,取走计算机
    private Resource resource;
    public GetThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Computer{
    private String name; //计算机名称
    private double price; // 价格
    private static int count = 0; // 数量

    public Computer(String name,double price){ //Computer构造函数
        this.name = name;
        this.price = price;
        count++;
    }

    public String toString(){ // 重写toString方法
        return "[生产了"+count+"台计算机] -- "+"计算机名称为: "+this.name+"价格为: "+this.price;
    }
}
class Resource{
    private Computer computer;
    public synchronized void make() throws Exception{ //数据同步,创建计算机方法
        if (this.computer!=null){ // 如果计算机不为空,即已经创建计算机
            super.wait(); // 切换线程至取出计算机
        }
        Thread.sleep(100); // 等待时间
        this.computer = new Computer("mac-book-air",12000); // 创建一台计算机
        System.out.println("["+Thread.currentThread().getName()+"新建计算机]"+this.computer);
        super.notifyAll(); // 唤醒等待方法
    }
    public synchronized void get() throws Exception{
        if (this.computer == null){ // 如果计算机为空,则创建计算机
            super.wait();
        }
        Thread.sleep(200);
        System.out.println("["+Thread.currentThread().getName()+"取出计算机]"+this.computer);
        this.computer = null;
        super.notifyAll();
    }
}
