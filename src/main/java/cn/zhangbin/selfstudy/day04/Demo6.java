package cn.zhangbin.selfstudy.day04;

import java.io.*;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        SendThread send = new SendThread();
        ReceiveThread receive = new ReceiveThread();
        send.getOutput().connect(receive.getInput()); // 进行管道流链接
        new Thread(send,"消息发送线程").start();
        new Thread(receive,"消息接受线程").start();
    }
}
class SendThread implements Runnable{
    private PipedOutputStream output; // 管道输出流
    public SendThread(){
        this.output = new PipedOutputStream(); // 实例化管道输出流
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                this.output.write(("[第"+(i+1)+"次信息发送 - ]"+Thread.currentThread().getName()+"]www.baidu.com\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutput() {
        return output;
    }
}
class ReceiveThread implements Runnable{
    private PipedInputStream input; // 实例化管道输入流
    public ReceiveThread(){
        this.input = new PipedInputStream(); // 实例化管道输入流
    }
    @Override
    public void run() {
        byte[] data = new byte[1024]; // 读取字节数
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 所有的数据保存到内存输出流
        try {
            if ((len = this.input.read(data))!= -1){
                bos.write(data,0,len); // 所有的数据保存到内存流
            }
            System.out.println("{"+Thread.currentThread().getName()+"接受消息} \n"+ new String(bos.toByteArray()));
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PipedInputStream getInput() {
        return input;
    }
}