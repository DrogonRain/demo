package cn.zhangbin.selfstudy.thread;

import org.omg.SendingContext.RunTime;

public class RunTimeDemo {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println(run.availableProcessors()); // 获取进程数
        System.out.println(run.maxMemory()); // 获取最大内存空间
        System.out.println(run.totalMemory()); // 获取可用内存空间
        System.out.println(run.freeMemory()); // 获取空闲内存空间
//        run.gc(); // 手工GC处理
    }
}
