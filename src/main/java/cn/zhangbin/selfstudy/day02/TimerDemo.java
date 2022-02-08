package cn.zhangbin.selfstudy.day02;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTest(),100,1000);
    }

}
class MyTest extends TimerTask{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了"+System.currentTimeMillis());
    }
}
