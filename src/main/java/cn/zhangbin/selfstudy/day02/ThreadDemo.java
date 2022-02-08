package cn.zhangbin.selfstudy.day02;

public class ThreadDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu1.com");
            Channel.setMessage(msg);
            Channel.send(); // 发送消息
        },"消息发送者A").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu2.com");
            Channel.setMessage(msg);
            Channel.send(); // 发送消息
        },"消息发送者B").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu3.com");
            Channel.setMessage(msg);
            Channel.send(); // 发送消息
        },"消息发送者C").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu1.com");
            Channel2 channel2 = new Channel2(msg);
            channel2.send(); // 发送消息
        },"消息发送者1").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu2.com");
            Channel2 channel2 = new Channel2(msg);
            channel2.send(); // 发送消息
        },"消息发送者2").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("www.baidu3.com");
            Channel2 channel2 = new Channel2(msg);
            channel2.send(); // 发送消息
        },"消息发送者3").start();
        Message message = new Message();
        message.setInfo("str");
        new Thread(new Channel3(message),"测试线程").start();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
class Channel{ //消息发送通道
    private static final ThreadLocal<Message> THREAD_LOCAL = new ThreadLocal<>();
    public Channel(){ }
    public static void setMessage(Message m){
        THREAD_LOCAL.set(m);
    }
    public static void send(){
        System.out.println("["+Thread.currentThread().getName()+"]"+THREAD_LOCAL.get().getInfo());
    }
}
class Channel2{
    private Message message;
    public Channel2(Message message){
        this.message = message;
    }
    public void send(){
        System.out.println("["+Thread.currentThread().getName()+"]"+this.message.getInfo());
    }
}
class Channel3 implements Runnable{
    private Message message;
    public Channel3(Message message){
        this.message = message;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("["+Thread.currentThread().getName()+"]"+this.message.getInfo());
        }
    }
}
class Message{ //要发送的消息体
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
