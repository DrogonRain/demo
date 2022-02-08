package cn.zhangbin.selfstudy.thread;

import sun.nio.ch.Net;

public class JavaAPIDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try(IMessage msg = new NetMessage("消息体")){
            msg.send();
        }catch (Exception e){

        }
        long end = System.currentTimeMillis();
        System.out.println(end-start); // 计算操作耗时
    }
}
interface IMessage extends AutoCloseable{
    public void send(); //消息发送
}
class NetMessage implements IMessage{
    private String msg;
    public NetMessage(String msg){
        this.msg = msg;
    }

    public boolean open(){
        System.out.println("[新建资源]");
        return true;
    }

    @Override
    public void send() {
        if (this.open()){
            System.out.println("[消息发送]"+this.msg);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("[资源关闭]");
    }
}
