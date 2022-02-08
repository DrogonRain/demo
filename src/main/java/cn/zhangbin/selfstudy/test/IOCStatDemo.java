package cn.zhangbin.selfstudy.test;

import cn.zhangbin.selfstudy.factory.Factory;

import java.util.Arrays;

public class IOCStatDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Factory.getInstance().ifStat()));
    }
}
